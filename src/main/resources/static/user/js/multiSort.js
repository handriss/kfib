$(document).ready(function(){

    console.log("just entered multisort");

    // highlighted
    // userSort
    // projectSort

    var classesNodeList = document.querySelectorAll(".userSort");
    var classes = Array.prototype.map.call(classesNodeList, function(element) {
        console.log(element);
    });

    // TODO:
    // - create real-looking posts, with at least one post in each category
    // - add the categories to the posts in the back-end
    // - add the categories to the posts in thymeleaf
    // - add click listeners to the selector buttons in multiSort.js
    // - a post should only show if its selector button is clicked
    //     - save selector buttons into a list
    //     - research how to show/hide html elements, do i need an own implementation, is there a fucntion like that?




});