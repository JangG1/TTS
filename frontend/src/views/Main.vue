<template>
<div>
    <div style="text-align:center;">
        <h1> 번역 </h1>
        <hr>
    </div>
    <form class="container" name="login_member">
        <div class="tempDiv">음성 종류
            <select name="voice" v-model="voice">
                <option value="">--음성을 선택해주세요--</option>
                <option value="nara"> 아라 한국어 여성 </option>
                <option value="nara_call"> 아라(상담원) 한국어 여성 </option>
                <option value="nminyoung"> 민영 한국어 여성 </option>
                <option value="nyejin"> 예진 한국어 여성 </option>
                <option value="mijin"> 미진 한국어 여성 </option>
                <option value="jinho"> 진호 한국어 남성 </option>
                <option value="clara"> 클라라 영어 여성 </option>
                <option value="matt"> 매트 영어 남성 </option>
                <option value="shinji"> 신지 일본어 남성 </option>
                <option value="meimei"> 메이메이 중국어 여성 </option>
                <option value="liangliang"> 량량 중국어 남성 </option>
                <option value="jose"> 호세 스페인어 남성 </option>
                <option value="carmen"> 카르멘 스페인어 여성 </option>
                <option value="nminsang"> 민상 한국어 남성 </option>
                <option value="nsinu"> 신우 한국어 남성 </option>
                <option value="nhajun"> 하준 한국어 남성(아동) </option>
                <option value="ndain"> 다인 한국어 여성(아동) </option>
                <option value="njiyun"> 지윤 한국어 여성 </option>
                <option value="nsujin"> 수진 한국어 여성 </option>
                <option value="njinho"> 진호 한국어 남성 </option>
                <option value="njihun"> 지훈 한국어 남성 </option>
                <option value="njooahn"> 주안 한국어 남성 </option>
                <option value="nseonghoon"> 성훈 한국어 남성 </option>
                <option value="njihwan"> 지환 한국어 남성 </option>
                <option value="nsiyoon"> 시윤 한국어 남성 </option>
                <option value="ngaram"> 가람 한국어 남성 </option>
                <option value="ntomoko"> 토모코 일본어 여성 </option>
                <option value="nnaomi"> 나오미 일본어 여성 </option>
                <option value="dnaomi_joyful"> 나오미(기쁨) 일본어 여성 </option>
                <option value="dnaomi_formal"> 나오미(뉴스) 일본어 여성 </option>
                <option value="driko"> 리코 일본어 여성 </option>
                <option value="deriko"> 에리코 일본어 여성 </option>
                <option value="nsayuri"> 사유리 일본어 여성 </option>
                <option value="ngoeun"> 고은 한국어 여성 </option>
                <option value="neunyoung"> 은영 한국어 여성 </option>
                <option value="nsunkyung"> 선경 한국어 여성 </option>
                <option value="nyujin"> 유진 한국어 여성 </option>
                <option value="ntaejin"> 태진 한국어 남성 </option>
                <option value="nyoungil"> 영일 한국어 남성 </option>
                <option value="nseungpyo"> 승표 한국어 남성 </option>
                <option value="nwontak"> 원탁 한국어 남성 </option>
                <option value="dara_ang"> 아라(화남) 한국어 여성 </option>
                <option value="nsunhee"> 선희 한국어 여성 </option>
                <option value="nminseo"> 민서 한국어 여성 </option>
                <option value="njiwon"> 지원 한국어 여성 </option>
                <option value="nbora"> 보라 한국어 여성 </option>
                <option value="njonghyun"> 종현 한국어 남성 </option>
                <option value="njoonyoung"> 준영 한국어 남성 </option>
                <option value="njaewook"> 재욱 한국어 남성 </option>
                <option value="danna"> 안나 영어 여성 </option>
                <option value="djoey"> 조이 영어 여성 </option>
                <option value="dhajime"> 하지메 일본어 남성 </option>
                <option value="ddaiki"> 다이키 일본어 남성 </option>
                <option value="dayumu"> 아유무 일본어 남성 </option>
                <option value="dmio"> 미오 일본어 여성 </option>
                <option value="chiahua"> 차화 대만어 여성 </option>
                <option value="kuanlin"> 관린 대만어 남성 </option>
                <option value="dnaomi_joyful"> 나오미(기쁨) 일본어 여성 </option>
                <option value="dnaomi_formal"> 나오미(뉴스) 일본어 여성 </option>
                <option value="driko"> 리코 일본어 여성 </option>
                <option value="deriko"> 에리코 일본어 여성 </option>
                <option value="nes_c_hyeri"> 혜리 한국어 여성 </option>
                <option value="nes_c_sohyun"> 소현 한국어 여성 </option>
                <option value="nes_c_mikyung"> 미경 한국어 여성 </option>
                <option value="nes_c_kihyo"> 기효 한국어 남성 </option>
            </select>
            <!--속도조절-->
            <div>
                속도
                <select name="voiceSpeed" v-model="speed">
                    <option value="">0</option>
                    <option value="-5">-5</option>
                    <option value="-4">-4</option>
                    <option value="-3">-3</option>
                    <option value="-2">-2</option>
                    <option value="-1">-1</option>
                    <option value="0">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </div>
            <!--볼륨조절-->
            <div>
                볼륨
                <select name="voiceVolume" v-model="volume">
                    <option value="">0</option>
                    <option value="-5">-5</option>
                    <option value="-4">-4</option>
                    <option value="-3">-3</option>
                    <option value="-2">-2</option>
                    <option value="-1">-1</option>
                    <option value="0" selected>0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </div>
            <hr>
            <br>
            <textarea class="textBox" rows="5" cols="20" v-model="text" placeholder="내용 입력"></textarea>
            <br>
            <hr>
            <button type="button" @click="play('http://localhost:7777/tts.mp3')">재생</button>
            <button type="button" value="page move" @click="movepage()">번역</button>
            <button type="button" value="page move" @click="down()">MP3 다운로드</button>
            <button type="button" @click="sendData2()">전송</button>
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
            text: '',
            voice: '',
            speed: '',
            volume: ''
        }
    },

    methods: {
        getTodos() {
            this.$http.get('http://localhost:7777/tts.mp3', {
                    headers: {
                        'Access-Control-Allow-Origin': '*',
                        'Content-Type': 'application/json; charset = utf-8'
                    }
                })
                .then((result) => {
                    console.log(result)
                })
                .catch(e => {
                    console.log('error:', e)
                })
        },
        sendData1() {
            axios({
                    url: 'api/tts/axios',
                    method: 'POST'
                })
                .then((response) => {
                    this.tests = response.data
                })
        },
        sendData2() {
            axios({
                    url: 'api/tts/server',
                    method: 'post',
                    data: {
                        data1: this.text,
                        data2: this.voice,
                        data3: this.speed,
                        data4: this.volume,
                    }
                })
                .then((response) => {
                    console.log(response)
                })
        },

        movepage() {
            location.href = "http://localhost:7777/tts.mp3";
        },
        down() {
            location.href = "http://localhost:8085/download";
        },

        download() {
            axios({
                //url: 'http://localhost:8888/tts2',
                url: 'http://localhost:7777/resources/tts.mp3',
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
        this.sendData1();
        this.sendData2();
    },
    mounted() {
        this.getTodos();
    }
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
