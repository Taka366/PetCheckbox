function validateRegistForm() {
    // グループ名
    const groups = ['action', 'timeframe','name'];
    let allValid = true;

    groups.forEach(groupName => {
        const checkboxes = document.querySelectorAll(`input[name="${groupName}"]`);
        const isChecked = Array.from(checkboxes).some(checkbox => checkbox.checked);

        if (!isChecked) {
			let alertField;
			if (groupName == 'action'){
				alertField = '「実施内容」';
				}
			else if (groupName == 'timeframe'){
				alertField = '「実施時間帯」';
			}
			else if (groupName == 'name'){
				alertField = '「実施者」';
			}
			else{
				alertField = '「不明」';
			}
            alert(`${alertField}の項目を選択してください。`);
            allValid = false; // 少なくとも1つのグループが無効
        }
    });
    return allValid; // すべてのグループが有効であればフォーム送信を許可
}