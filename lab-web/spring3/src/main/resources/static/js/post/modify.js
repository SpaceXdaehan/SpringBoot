/**
 * 포스트 게시물을 업데이트 하거나 삭제하는 js
 */
document.addEventListener('DOMContentLoaded', () => {
    
    // <form> 요소를 찾음.
   const postModifyForm = document.querySelector('#postModifyForm');
   
   const btnUpdate = document.querySelector('#btnUpdate');
   btnUpdate.addEventListener('click', (e) => {
        alert("업데이트");
        
        const title = document.querySelector('input#title').value; 
        const content = document.querySelector('textarea#content').value; 
        if (title === '' || content === '') {
            alert('제목과 내용은 반드시 입력하세요.');
            return; 
        }
        
        const check = confirm('변경 내용을 저장할까요?');
        if (check) {
            postModifyForm.action = '/post/update';
            postModifyForm.method = 'post';
            postModifyForm.submit();
        }
   });
   
   const btnDelete = document.querySelector('#btnDelete');
   btnDelete.addEventListener('click', (e) => {     
      const check = confirm('정말 삭제할까요?');
        if (!check) {
            return;
        }
            postModifyForm.action = '/post/delete';    // submit 요청주소
            postModifyForm.method = 'post';     // submit 요청 방식
            postModifyForm.submit();        // 폼 제충(submit) 요청 보내기.
   });
   
   
   
});