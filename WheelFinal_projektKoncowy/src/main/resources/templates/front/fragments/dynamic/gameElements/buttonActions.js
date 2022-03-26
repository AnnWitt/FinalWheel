
function toInactive() {
    return "buttonInactive";
}

function toActive() {
    return "buttonActive";
}

function toKnown(){
    return "letterKnown";
}

function toUnknown(){
    return "letterUnknown";

}

function toEmpty(){
    newDiv += "<button class='buttonEmpty' onclick='newTask(this)'>New Task</button>";
}

/*function dupa(id) {
    var element = document.getElementById(id)
    element.className = (element.className == "buttonEmpty") ? "buttonActive" : "buttonEmpty";
}*/

/*function dupa(class-name) {
  /!*  var element = document.getElementById(id)*!/
    const selectorElement = document.querySelector('.class-name');
    selectorElement.className = (selectorElement.className == "buttonActive") ? "buttonInactive" : "buttonEmpty";
}*/

function changeColor() {
    color='#000000';
}



/*
wywołanie toEmpty();*/

//przyklady do zastosowania później
const styl1=toEmpty();
var styl2=toEmpty();
