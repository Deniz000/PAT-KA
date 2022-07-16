document.getElementById("add").addEventListener("click", formHandler)

function formHandler() {
    let grs = document.getElementById("entry")
    if (grs.value) {
        addItem(grs.value)
        grs.value = " "
    }
    else {
        console.log("Hatalı giriş")
        window.alert("boş öğe eklenmez")
    }
}
let listDOM = document.getElementById('list')
let span = document.createElement('span').innerHTML = '<span id="deleteSpan">&cross;</span>'
function addItem(grs) {
    let liDOM = document.createElement('li')
    liDOM.innerHTML = `<p>${grs}</p>${span}`
    listDOM.append(liDOM)
}
let spanDOM = document.getElementById().addEventListener("click", deleteFun)
function deleteFun() {
    window.alert("yes")
}

