var a = [5, 3, 2, 8, 1, 4];

a.sort(function (a, b) {
    if (a % 2 == 0 || b % 2 == 0) {
        return;
    }
    return a - b;

})
console.log(a);