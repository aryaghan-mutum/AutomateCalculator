
/*
Anurag Muthyam Cal.js 
*/

var keys = document.querySelectorAll('#calculator span');
var operators = ['+', '-', 'x', '/'];
var count = false;
var isEvaluated = false;

for(var i = 0; i < keys.length; i++) {
	keys[i].onclick = async function(event) {
		var input = document.querySelector('.screen');
		var inputValue = input.innerHTML;
		var buttonValue = this.innerHTML;

		if (buttonValue == 'C') { input.innerHTML = ""; }
		else if (buttonValue == '=') {
			var equation = inputValue;
			var lastChar = equation[equation.length - 1];

			equation = equation.replace(/x/g, '*')

			if (operators.indexOf(lastChar) > -1 || lastChar == '.'){
				equation = equation.replace(/.$/, "");
			}

			if (equation) { input.innerHTML = eval(equation); }
			count = false;
			isEvaluated = true;
		}
		else if (operators.indexOf(buttonValue) > -1) {
			var lastChar = inputValue[inputValue.length - 1];

			if (isEvaluated) {
				input.innerHTML = ""
				isEvaluated = false;
			}
			if (inputValue != "" && operators.indexOf(lastChar) == -1) {
				input.innerHTML += buttonValue;
			}
			else if (inputValue == "" && buttonValue == "-") {
				input.innerHTML += buttonValue;
			}
			else if (operators.indexOf(lastChar) > -1 && inputValue.length > 1) {
				input.innerHTML = inputValue.replace(/.$/, buttonValue);
			}
			count = false;
		}
		else if (buttonValue == ".") {
			if (!count) {
				count = true;
				input.innerHTML += buttonValue;
			}
		}
		else {
			if (isEvaluated) {
				input.innerHTML = ""
				isEvaluated = false;
			}
			input.innerHTML += buttonValue;
		}

		e.preventDefault();
	} //end function
} //end loop