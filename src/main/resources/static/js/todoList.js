const Day = document.querySelector('.day');
const month = document.querySelector('.month-name');
const date = new Date();

const pre = document.querySelector('.left');
const next = document.querySelector('.right');

const todoField = document.querySelector('.todo');
const todoTitle = document.querySelector('.todo-title');
const todoList = document.querySelector('.todoList');

//const input = document.querySelector('input[type="text"]');
//const add = document.querySelector('.add');
//const reset = document.querySelector('.reset');
//const allReset = document.querySelector('.allreset');


let currentMon = date.getMonth()+1;
let currentYear = date.getFullYear();
let currentDay = date.getDate();

let DayOfChoice = currentDay;
let MonOfChoice = currentMon;
let yearOfChoice = currentYear;

let year = currentYear;
let mon = currentMon;

let clickEventArr = [];
let storeToDo = [];

function isLeapYear(year){
    return (year%4==0)&&(year%400==0||year%100!=0);
}

function getDayOfMon(mon,year){
    if(mon===1||mon===3||mon===5||mon===7||mon===8||mon===10||mon===12){
        return 31;
    }
    else if(mon===2){
        return isLeapYear(year)? 29 : 28;
    }
    else{
        return 30;
    }
}

function getDay(year,mon,date){
    const conYMD = year+'-'+mon+'-'+date;
    return(new Date(conYMD).getDay());
}
function makeCalendar(year,mon,dayCount){
    clickEventArr=[];
    Day.innerHTML='';
    let getFirstDay = getDay(year,mon,1);
    let previousMon;
    if(currentMon-1<0){
        previousMon = 12;
    }
    else{
        previousMon = currentMon - 1;
    }
    let getDayOfPreMon = getDayOfMon(previousMon,year);
    for(let i=(getFirstDay+6)%7; i>0; i--){
        const listPre = document.createElement('li');
        listPre.textContent = `${getDayOfPreMon-(i-1)}`;
        listPre.style.opacity = '0.5';
        listPre.classList.add('disabled');
        Day.appendChild(listPre);
    }

    for(let i=1; i<=dayCount; i++){
        if(i===currentDay&&year===currentYear&&mon===currentMon){
            //선택한 년, 월, 일 다를 때 현재 날짜에 검은색 테두리
            const onlyOneList = document.createElement('li');

            onlyOneList.textContent = `${i}`;
            if(currentYear === yearOfChoice && currentMon === MonOfChoice && currentDay === DayOfChoice){
                onlyOneList.style.border = '3px solid red';
            }
            else{
                onlyOneList.style.border = '3px solid black';
            }

            if(0===getDay(year,mon,i)){
                onlyOneList.style.color = 'red';
            }
            else if(6==getDay(year,mon,i)){
                onlyOneList.style.color = 'blue';
            }

            //현재 년, 월 같을 때

            Day.addEventListener('click',(event)=>{
                if(event.target!==onlyOneList){
                    onlyOneList.style.border = '3px solid black';
                }
            });

            Day.appendChild(onlyOneList);
            continue;
        }

        const list = document.createElement('li');
        list.textContent = `${i}`;
        if(i===DayOfChoice&&year===yearOfChoice&&mon===MonOfChoice){
            list.style.border = '3px solid red';
            Day.addEventListener('click',(event)=>{
                if(event.target!==list){
                    list.style.border = 'none';
                }
            });
        }

        if(0===getDay(year,mon,i)){
            list.style.color = 'red';
        }
        else if(6==getDay(year,mon,i)){
            list.style.color = 'blue';
        }

        Day.appendChild(list);
    }
}

function setMonthTitle(year,mon){
    month.textContent = `${year}.${mon}`
}

function nextMonthOrYear(){
    if(mon===12){
        year = year+1;
        mon = 1;
    }
    else{
        mon = mon+1;
    }
    setMonthTitle(year,mon);
    makeCalendar(year,mon,getDayOfMon(mon,year));
}

function preMonthOrYear(){
    if(mon===1){
        year = year-1;
        mon = 12;
    }
    else{
        mon = mon-1;
    }
    setMonthTitle(year,mon);
    makeCalendar(year,mon,getDayOfMon(mon,year));
}


function main(){
    setMonthTitle(year,mon);
    makeCalendar(year,mon,getDayOfMon(mon,year));
    todoTitle.textContent = `선택된 날짜 :  ${year}.${mon}.${currentDay}`;
    displayToDoOnDays();






}

function displayToDoOnDays(){ // 추가한 todolist 보여주는 부분
    todoList.innerHTML='';
    const YMD = year+'-'+mon+'-'+DayOfChoice;
    let arrayToDo;
    const elementToDo = document.createElement('li');
    if(!localStorage.getItem(YMD)){
        return;
    }
    if(localStorage.getItem(YMD).includes(',')){

        arrayToDo = localStorage.getItem(YMD).split(',');
        arrayToDo.forEach((value)=>{
            const deleteBtn = document.createElement('button');
            deleteBtn.setAttribute('class','deleteBtn');
            deleteBtn.innerHTML = '<i class="far fa-minus-square"></i>';
            const elementToDo = document.createElement('li');

            elementToDo.innerText = value;
            elementToDo.appendChild(deleteBtn);

            elementToDo.scrollTo();

            todoList.appendChild(elementToDo);
        });

    }
    else{
        const deleteBtn = document.createElement('button');
        deleteBtn.setAttribute('class','deleteBtn');
        deleteBtn.innerHTML = '<i class="far fa-minus-square"></i>';

        elementToDo.textContent = localStorage.getItem(YMD);
        elementToDo.appendChild(deleteBtn);
        todoList.appendChild(elementToDo);
    }
}

// 달력 넘기기 이벤트
pre.addEventListener('click',preMonthOrYear);
next.addEventListener('click',nextMonthOrYear);








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

function api(){





}


main();



