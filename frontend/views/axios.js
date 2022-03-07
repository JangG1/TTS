import axios from 'axios'


 /* play: function(sound) {
    if (sound) {
var audio = new Audio(sound);
    audio.play();}
}*/

    axios({
            url: 'http://localhost:8888/tts2',
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
  
