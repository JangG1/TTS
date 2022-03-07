var cors = require('cors');
var express = require('express');
var app = express();
var client_id = 'zvyh4atvgh';
var client_secret = 'MWlUUGIrdLgCIE4ASgRrkIRn4XdQFfwFwmceH9vN';
var fs = require('fs');
var cons = require('consolidate');
app.use(cors());

//by.지원_post용body_구현중
/*const bodyParser = require('body-parser')
app.use(bodyParser.urlencoded({extended:false}))*/

app.locals.pretty = true;
app.use(express.static('static'))

//by.지원_View 엔진 셋업
app.engine('ejs', cons.swig)
app.set('views', './views');
app.set('view engine', 'ejs');

//by.지원_메인화면
app.get('/main', (req, res) => {
  res.render('main');
})


//CLOVA TTS API
//By지원_텍스트,보이스,속도,볼륨 입력값을 받아 MP3 생성
app.get('/tts1', function(req, res) {
  var putText = req.query.putText;
  var voice = req.query.voice;
  var voiceSpeed = req.query.voiceSpeed;
  var voiceVolume = req.query.voiceVolume;
  //var putText = req.body.putText;
  var api_url = 'https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts';
  var request = require('request');
  var options = {
    url: api_url,
    form: { speaker: voice, volume: voiceVolume, speed: voiceSpeed, pitch: '0', 
    text: putText, format: 'mp3' },
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

//구현중
/*app.post('/tts3', function(req, res) {
  //var putText = req.query.putText;
  var putText = req.body.putText;
  var api_url = 'https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts';
  var request = require('request');
  var options = {
    url: api_url,
    form: { speaker: 'nara', volume: '0', speed: '0', pitch: '0', 
    text: putText, format: 'mp3' },
    headers: { 'X-NCP-APIGW-API-KEY-ID': client_id, 'X-NCP-APIGW-API-KEY': client_secret },
  };
  var writeStream = fs.createWriteStream('./tts1.mp3');
  var _req = request.post(options).on('response', function(response) {
    console.log(response.statusCode); // 200
    console.log(response.headers['content-type']);
  });
  _req.pipe(writeStream); // file로 출력
  _req.pipe(res); // 브라우저로 출력
});*/

//By지원_생성된 MP3 파일 재생, 다운로드
app.get('/tts2', function(req, res) {
  var api_url = 'https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts';
  var request = require('request');
  var options = {
    url: api_url,
    form: { speaker: 'nara', volume: '0', speed: '0', pitch: '0', 
    text: '오늘도금요일입니다', format: 'mp3' },
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


//by.지원_포트
app.listen(8888, function() {
  console.log('http://localhost:8888/main');
  console.log('http://localhost:8888/tts2');
});
