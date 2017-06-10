$(document).ready(function(){

    var tagDictionary = {
        "Újságíró": "journalist",
        "Döntéshozó" : "decisionMaker",
        "Civil szervezet" : "ngo",
        "Elemző" : "analyst",
        "Állampolgár" : "citizen",

        "Átláthatóság" : "transparency",
        "Technikai kivetítés" : "baselineProjection",
        "Költségvetési elemzés" : "budgetAnalysis",
        "Módszertan" : "methodology",
        "OBI" : "obi",
        "Hatásvizsgálat" : "impactAssessment",
        "Egyéb elemzések" : "other"
    };

    console.log(tagDictionary);

    Array.prototype.map.call(document.querySelectorAll(".userSort"), function(element) {

        element.addEventListener("click", function(){

            // console.log(element.getElementsByTagName("span")[0].innerHTML);
            // console.log(tagDictionary[element.getElementsByTagName("span")[0].innerHTML]);

            var toggleableElements = document.getElementsByClassName(tagDictionary[element.getElementsByTagName("span")[0].innerHTML]);
            for (var i = 0; i < toggleableElements.length; i++){
                if( toggleableElements[i].style.display === 'none'){
                    toggleableElements[i].style.display = 'block';
                }else{
                    toggleableElements[i].style.display = 'none';
                }
            }

        });

    });

    // TODO:
    // - add click listeners to the selector buttons in multiSort.js
    // - a post should only show if its selector button is clicked
    //     - save selector buttons into a list
    //     - research how to show/hide html elements, do i need an own implementation, is there a fucntion like that?




});