function getVal() {
    var x = document.getElementById("quantity");

    document.getElementsByName('result')[0].placeholder=(x.value*1.08).toString()+"$";
    document.getElementById("result").innerHTML = x.value.toUpperCase();
}

//-------

document.getElementById('recipient').addEventListener('input', function (e) {
    var target = e.target, position = target.selectionEnd, length = target.value.length;
    target.value = target.value.replace(/[^\dA-Z]/g, '').replace(/(.{4})/g, '$1 ').trim();
    target.selectionEnd = position += ((target.value.charAt(position - 1) === ' ' && target.value.charAt(length - 1) === ' ' && length !== target.value.length) ? 1 : 0);
});

//---------

var currencyInput = document.querySelector('input[type="currency"]')
var currency = 'EUR' // https://www.currency-iso.org/dam/downloads/lists/list_one.xml

// format inital value
onBlur({target:currencyInput})

// bind event listeners
currencyInput.addEventListener('focus', onFocus)
currencyInput.addEventListener('blur', onBlur)


function localStringToNumber( s ){
    return Number(String(s).replace(/[^0-9.,-]+/g,""))
}

function onFocus(e){
    var value = e.target.value;
    e.target.value = value ? localStringToNumber(value) : ''
}

function onBlur(e){
    var value = e.target.value

    var options = {
        maximumFractionDigits : 0,
        currency              : currency,
        style                 : "currency",
        currencyDisplay       : "symbol"
    }

    e.target.value = (value || value === 0)
        ? localStringToNumber(value).toLocaleString(undefined, options)
        : ''
}