function submitCheck(){
    if(window.confirm('送信しますか？')) {
      return true; // 「OK」なら送信
    }
    else {
      window.alert('キャンセルしました。');
      return false; // 「キャンセル」なら送信しない
    }
  }