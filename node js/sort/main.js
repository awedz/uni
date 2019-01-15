var name = require("./jason.json");
var name2 = [];
var lowbig = [];
name.forEach(element => {
    name2.push(element.name);
});


name2.sort();
lowbig = name.sort(function (a, b) {
    let nameA = a.name.toUpperCase();
    let nameB = b.name.toUpperCase();
    if (nameA < nameB) {
        return -1;
    }
    if (nameA > nameB) {
        return 1;
    }
    return 0;
})

console.log(a);