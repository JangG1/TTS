//var prompt = require("prompt-sync")();
//var putText = prompt('내용을 입력하세요 : ');


var cors = require('cors');
var express = require('express');
var app = express();
var client_id = 'zvyh4atvgh';
var client_secret = 'MWlUUGIrdLgCIE4ASgRrkIRn4XdQFfwFwmceH9vN';
var fs = require('fs');
app.use(cors());

//const putText = prompt('내용을 입력하세요 : ');

app.get('/test', function(req, res) {

  var template = `
  <!DOCTYPE html>
  <html lang="">
    <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width,initial-scale=1.0">
    </head>
    <body>
    <textarea id='text' rows="5" cols="20">{putText}</textarea>
    <button id="speak" onclick=exp()>Speak Text</button>

    <audio controls>
    <source src="http://localhost:7777/tts" type="audio/ogg">
    </audio>
    <button type="button" onclick="play('http://localhost:7777/tts')">재생</button>
    <button type="button" value="page move" onclick="download()">MP3 다운로드</button>

    

<!---------------------------------------------------------------------------------->

    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script>
    function play(sound) {
        if (sound) {
    var audio = new Audio(sound);
        audio.play();}
    }
    function download() {
        axios({
                url: 'http://localhost:7777/tts',
                method: 'GET',
                responseType: 'arraybuffer', 
            }).then((response) => {
                const url = window.URL.createObjectURL(new Blob([response.data]));
                const link = document.createElement('a');
                link.href = url;
                link.setAttribute('download', 'file.mp3'); 
                document.body.appendChild(link);
                link.click();
            });
        }
</script>
    </body>
  </html>
  
  `;
  res.end(template);
  
});
// function exp(){
// //var pt = document.getElementById('text').value;
//   //alert('123')
//   //alert(pt)
// }

app.get('/tts', function(req, res) {
  
  var api_url = 'https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts';
  var request = require('request');
  var options = {
    url: api_url,
    form: { speaker: 'jinho', volume: '0', speed: '0', pitch: '0', 
    text: '테스트중입니다'
    , format: 'mp3' },
    headers: { 'X-NCP-APIGW-API-KEY-ID': client_id, 'X-NCP-APIGW-API-KEY': client_secret },
  };
  var writeStream = fs.createWriteStream('./tts1.mp3');
  var _req = request.post(options).on('response', function(response) {
    console.log(response.statusCode); // 200
    console.log(response.headers['content-type']);
  });
  _req.pipe(writeStream); // file로 출력
  _req.pipe(res); // 브라우저로 출력
});

app.listen(7777, function() {
  console.log('http://localhost:7777/tts');
});

