const checkboxes = document.getElementsByName('select');
	
const selectAll = (allCheck) => {
	checkboxes.forEach((checkbox) => {
		checkbox.checked = allCheck.checked;
	});
}