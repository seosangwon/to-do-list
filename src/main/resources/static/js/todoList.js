'use strict';


let itemList = [];

let inputButton = document.querySelector(".input_button");
inputButton.addEventListener("click", addItem);

function addItem() {
    let itemSet = {
        item : document.querySelector(".item").value,
        complete : false
    };
    
    if(itemSet.item != null){
        itemList.push(itemSet);
        document.querySelector(".item").value = "";
        document.querySelector(".item").focus();
    }
    showList();
}

function showList() {
    let list = "<ul>"
    for(let i=0; i<itemList.length; i++){
        if(itemList[i].complete == false){
            list += "<li>"+ "<span class='check_button' id=" + i + ">" + " ✔︎ " + "</span>" + itemList[i].item + "<span class='close' id=" + i + ">" + " ❌ " + "</span></li>";
        }
        else {
            list += "<li class='checked'>" + "<span class='check_button' id=" + i + ">" + " ✔︎ " + "</span>" + itemList[i].item + "<span class='close' id=" + i + ">" + " ❌ " + "</span></li>";
        }
    }
    list += "</ul>";
    document.querySelector(".item_list").innerHTML = list;

    let deleteButtons = document.querySelectorAll(".close");
    for (let i = 0; i < deleteButtons.length; i++) {
        deleteButtons[i].addEventListener("click", deleteItem);
    }

    let checkButtons = document.querySelectorAll(".check_button");
    for (let i = 0; i < checkButtons.length; i++) {
        checkButtons[i].addEventListener("click", checkItem);
    }
}

function deleteItem() {
    let id = this.getAttribute("id");
    itemList.splice(id, 1); // id부터 1개 잘라낸다는 뜻
    showList();
}

function checkItem() {
    let id = this.getAttribute("id");
    if(itemList[id].complete == true){
        itemList[id].complete = false;
    }
    else {
        itemList[id].complete = true;
    }
    showList();
}