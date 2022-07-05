let names = prompt("İsminizi giriniz");
let added = document.querySelector("#myName")
added.innerHTML = names;
let clock = document.querySelector("#myClock")
let tarih = new Date();

//gün bilgisini sayısal alır ve gun fonksiyonuna verir
var date = new Date().getDay().toLocaleString('tr-TR');

function tekrar() {
    clock.innerHTML = saat() + "." + dakika() + "." + saniye() + " " + gun(date);
}
setInterval(tekrar, 1000);

function saat() {
    var hour = new Date().getHours().toLocaleString('tr-TR');
    return hour;
}
function dakika() {
    var minute = new Date().getMinutes().toLocaleString('tr-TR');
    return minute;
}
function saniye() {
    var milisecond = new Date().getSeconds().toLocaleString('tr-TR');
    return milisecond;
}

function gun(date) {
    let gun0 = "";
    switch (parseInt(date)) {
        case 1:
            gun0 = "Pazartesi"
            break;
        case 2:
            gun0 = "Salı"
            break;
        case 3:
            gun0 = "Çarşamba"
            break;
        case 4:
            gun0 = "Perşembe"
            break;
        case 5:
            gun0 = "Cuma"
            break;
        case 6:
            gun0 = "Cumartesi"
            break;
        case 7:
            gun0 = "Pazar"
            break;
    }
    return gun0;
}