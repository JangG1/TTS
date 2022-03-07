<template>
<div>
    <div style="text-align:center;">
        <h1>번역</h1>
        <!-- <audio autoplay loop controls> 
            <source src="http://localhost:7000/tts" type="audio/mpeg" >
            </audio> -->
        <hr>
    </div>
    <form class="container" name="login_member" preva>
        <div class="tempDiv">
            <select class="select-lang">
                <option value="ko-KR" selected>한국어</option>
                <option value="ja-JP">영어</option>
                <option value="en-US">일본어</option>
                <option value="ch-CH">중국어</option>
                <option value="sp-SP">스페인어</option>
            </select>
            <br>
            <textarea class="textBox" rows="5" cols="20" v-model="putText" placeholder="내용 입력"></textarea>
            <br>
            <button type="button" @click="download()">MP3 다운로드1</button>
            <!-- <button type="button" @click="download2()">MP3 다운로드2</button> -->
            <button type="button" @click="play('http://localhost:7777/tts')">재생</button>
   
            <button type="button" value="page move" @click="movepage()">번역</button>
            <!-- {{tests}} -->
            <!-- <div v-for="test in tests" :key="test">
                {{test.name}}
            </div> -->
            <!-- <span>
                <button type="button" class="classBtn" @click="startTTS">번역</button>
            </span> -->
        </div>
    </form>

</div>
</template>
<script type="text/javascript"> </script>
<script>
import axios from 'axios'
export default {
    data() {
        return {
            tests: [],
            frm: "",
        }
    },
    methods: {
        getData() {
            axios({
                    url: 'api/tts/axios',
                    method: 'GET'
                })
                .then((response) => {
                    this.tests = response.data
                })
        },
      
    movepage() {
      location.href = "http://localhost:7777/tts";
    },

        download() {
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
        },
        play(sound) {
      if (sound) {
        var audio = new Audio(sound);
        audio.play();
      }
    }

    },
    created() {
        this.getData();
    },
}
</script>

<style scoped>
.logo {
    margin-top: 30px;
    width: 150px;
    height: 150px;
    border-radius: 8px;
}

.container {
    background-color: #fafafa;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 800px;
}

.select-lang {
    width: 150px;
    height: 50px;
    text-align: center;
    font-size: 20px;
}

.textBox {
    width: 400px;
    padding-bottom: 400px;
    font-size: 19px;
}
</style>
