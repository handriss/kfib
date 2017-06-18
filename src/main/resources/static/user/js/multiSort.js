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

    Array.prototype.map.call(document.querySelectorAll(".userSort"), function(element) {

        element.addEventListener("click", function(){

            console.log("entered elementArray");

            var toggleableElements = document.getElementsByClassName(tagDictionary[element.getElementsByTagName("span")[0].innerHTML]);
            for (var i = 0; i < toggleableElements.length; i++){

                console.log("about to enter if");
                if(element.classList.contains("active")){
                    console.log("active true");
                    toggleableElements[i].style.display = 'block';
                }else{
                    console.log("active false");
                    toggleableElements[i].style.display = 'none';
                }

            }

        });

    });
});