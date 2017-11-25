/**
 * Created by c1673239 on 17/11/2017.
 */
//This has been used from http://jsbin.com/dulifezi/2/edit?html,css,js,output//

function rangeSlider(id, onDrag) {

    var range = document.getElementById(id),
        dragger = range.children[0],
        draggerWidth = 20, // width of your dragger
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
rangeSlider('range-slider-1', function(value) {
    document.getElementById('test-result').innerHTML = determineState(value, moods);
});

function determineState(percentage, statesArray) {
    valueOfOne = 100 / (statesArray.length -1);
    return statesArray[Math.round(percentage / valueOfOne)];
}
