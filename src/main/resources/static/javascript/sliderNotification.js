/**
 * Created by c1443907 on 07/12/2017.
 */


function rangeSliderNotification(id, onDrag) {

    var range = document.getElementById(id),
        dragger = range.children[0],
        draggerWidth = 50, // width of your dragger
        down = false,
        rangeWidth, rangeLeft;

    dragger.style.width = draggerWidth + 'px';
    dragger.style.left = -draggerWidth + 'px';
    dragger.style.marginLeft = (draggerWidth / 2) + 'px';

    range.addEventListener("mousedown", function(e) {
        rangeWidth = this.offsetWidth;
        rangeLeft = this.offsetLeft;
        down = true;
        updateDragger(e);
        return false;
    });

    document.addEventListener("mousemove", function(e) {
        updateDragger(e);
    });

    document.addEventListener("mouseup", function() {
        down = false;
    });

    function updateDragger(e) {
        if (down && e.pageX >= rangeLeft && e.pageX <= (rangeLeft + rangeWidth)) {
            dragger.style.left = e.pageX - rangeLeft - draggerWidth + 'px';
            if (typeof onDrag == "function") onDrag(Math.round(((e.pageX - rangeLeft) / rangeWidth) * 100));
        }
    }

}


// Run!
moods = ["Very Happy", "Happy", "Neutral", "Sad", "Upset", "Very Sad"];
//moods = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"];
rangeSliderNotification('range-slider-x', function(value) {
    document.getElementById('test-result-x').innerHTML = determineState(value, moods);

    //Following line added in by Jamie Highfield
    document.getElementById('result-emoji-x').src = "/images/emojis/" + (determineState(value, moods).replace(/\s/g, '')).toLowerCase() + ".png";
});

function determineState(percentage, statesArray) {
    valueOfOne = 100 / (statesArray.length -1);
    return statesArray[Math.round(percentage / valueOfOne)];
}
