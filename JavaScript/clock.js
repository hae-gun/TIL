const clockContainer = document.querySelector(".js-clock"),
clockTitle =  clockContainer.querySelector("h1");


function getTime(){
    const date = new Date();
    const minutes = date.getMinutes();
    const hour = date.getHours();
    const second = date.getSeconds();


    clockTitle.innerText = underTen(hour)+":"+underTen(minutes)+":"+underTen(second);

}

function underTen(s){

    var S = (s<10 ? `0${s}`:s);
    return `${S}`;
}


function init(){

    getTime();
    setInterval(getTime, 1000);
}
init();