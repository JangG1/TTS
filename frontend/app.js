var express = require('express');
var app = express();
var cons = require('consolidate');

const bodyParser = require('body-parser')
app.use(bodyParser.urlencoded({extended:false}))

app.locals.pretty = true;
app.use(express.static('static'))

// view engine setup
app.engine('ejs', cons.swig)
app.set('views', './views');
app.set('view engine', 'ejs');

app.get('/main', function(req, res){
  res.render('main');
});
app.get('/form_receiver', function(req, res){
  var putText = req.query.putText;
  res.send(putText+',');
});
app.post('/form_receiver', function(req, res){
  var putText = req.body.putText;
  res.send(putText+',');
});

app.get('/main', (req, res) => {
  res.render('main');
})

app.get('/login_check', (req, res) => {
  var id = req.query.id;
  var pw = req.query.pw;
  res.send(`id : ${id}, pw : ${pw}`);
})

app.post('/login_check', (req, res) => {
  var id = req.body.id;
  var pw = req.body.pw;
  res.send(`id : ${id}, pw : ${pw}`);
})

app.listen(3003, () => console.log('http://localhost:3003/form'));