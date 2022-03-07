// 네이버 음성합성 Open API 예제
var express = require('express');
var app = express();
var client_id = 'zvyh4atvgh';
var client_secret = 'MWlUUGIrdLgCIE4ASgRrkIRn4XdQFfwFwmceH9vN';
var fs = require('fs');
app.get('/tts', function(req, res) {
  var api_url = 'https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts';
  var request = require('request');
  var options = {
    url: api_url,
    form: { speaker: 'nara', volume: '0', speed: '0', pitch: '0', text: '좋은 하루 되세요', format: 'mp3' },
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
app.listen(3000, function() {
  console.log('http://localhost:3000/tts');
});
