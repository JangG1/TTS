<template>
<div>
    <div style="text-align:center;">
        <router-link v-bind:to="'/'"> <img src="@/assets/logo.jpg" alt="logo" style="width:130px; height:130px; margin-top:10px;"></router-link>
        <h1>회원가입</h1>
        <hr>
    </div>
    <!-- 입력 양식 -->
    <form class="container" name="login_member" preva>
        <div>
            <div class="tempDiv">
                <label class="labelClass" for="">*아이디</label>
                <input type="text" name="아이디" class="inputValues" id="id" v-model="signup.putid">
                <button class="classBtn" @click.prevent="idCheck"> 중복확인 </button>
            </div>
            <div class="tempDiv">
                <label class="labelClass" for="">*닉네임</label>
                <input type="text" name="닉네임" class="inputValues" id="nick" v-model="signup.putnick">
                <button class="classBtn" @click.prevent="nickCheck"> 중복확인 </button>
            </div>
            <div class="tempDiv">
                <label class="labelClass" for="">*비밀번호</label>
                <input v-model="signup.password" type="password" name="비밀번호" class="inputValues" id="pw" @keyup="passwordValid">
                <div v-if="!passwordValidFlag" class="pwFlag"> 유효하지 않은 비밀번호 입니다. </div>
            </div>
            <div class="tempDiv">
                <label class="labelClass" for="">*비밀번호확인</label>
                <input v-model="passwordCheck" type="password" name="비밀번호 확인" class="inputValues" @keyup="passwordCheckValid">
                <div v-if="!passwordCheckFlag" class="re_pwFlag"> 비밀번호가 동일하지 않습니다. </div>
            </div>
            <div class="tempDiv">
                <label class="labelClass" for="">*이름</label>
                <input type="text" name="username" class="username">
            </div>
            <div class="tempDiv">
                <label class="labelClass" for="">*전화번호</label>
                <input v-model="signup.mobile" type="text" name="전화번호" class="inputValues" @keyup="mobileCheckValid" placeholder="-없이 숫자만" maxlength="11" id="mobile">
                <div v-if="!mobileValidFlag" class="pwFlag"> 유효하지 않은 전화번호 입니다. </div>
            </div>
            <div class="tempDiv">
                <label class="labelClass" for="">*우편번호</label>

                <input type="text" class="inputValues" v-model="postcode" placeholder="우편번호">
                <span>
                    <button type="button" class="classBtn" @click="execDaumPostcode()">주소검색</button>
                </span>
            </div>
            <div class="tempDiv">
                <label class="labelClass" for="">*주소</label>
                <input type="text" class="inputValues" id="address" v-model="address" placeholder="주소">

            </div>
            <div class="tempDiv">
                <label class="labelClass" for="">*상세주소</label>
                <input type="text" class="inputValues" id="detailAddress" placeholder="상세주소">
            </div>
        </div>
    </form>
    <hr>
    <!-- 약고나 동의 부분 -->
    <div class="footer">
        <div class="CheckBox">
            <label class="Agree" id="agreement">
                <h2>약관동의</h2>
                <hr>
            </label><br>
            <div class="miniBox">
                <input type="checkbox" name="cb1" id="agreement1">귀하의 쇼핑몰에 회원으로 가입합니다(필수)<br>
                <input type="checkbox" name="cb2" id="agreement2">개인정보 수집 이용동의(필수)<br>
                <input type="checkbox" name="cb3" class="agree">마케팅 활용 및 광고성 정보 수신 동의 (선택)
            </div>
        </div>
        <div class="joinBtnArea">
            <button type="button" class="joinBtn" @click="submit"> <span>가입하기</span> </button>
        </div>
    </div>
</div>
</template>

<script>
import {
    createNamespacedHelpers
} from 'vuex'
const loginStore = createNamespacedHelpers('loginStore')
export default {
    data() {
        return {
            postcode: "",
            address: "",
            extraAddress: "",
            signup: {
                password: null,
                pwhint: '',
                pwhintans: null,
                putid: '',
                putnick: '',
                mobile: null,
            },
            passwordValidFlag: true,
            passwordCheck: '',
            passwordCheckFlag: true,
            mobileValidFlag: true,
            msg: '',
            checkIdFlag: false,
            checkNickFlag: false,
            checkPwdFlag: false,
            checkRePwdFlag: false,
            checkTelFlag: false,
            agreement: false,
        }
    },
    methods: {

        idCheck() {// 아이디 중복검사 이벤트
            try {
                for (let i = 0; i < this.getUserInfo.length; i++) {
                    if (this.getUserInfo[i].username == this.signup.putid) {
                        alert("이미 가입된 아이디 입니다.");
                        this.checkIdFlag = false;
                        return;
                    }
                }
                if ("" === this.signup.putid) {
                    alert("공백 입니다.");
                } else {
                    alert("등록 가능한 아이디 입니다.");
                    this.checkIdFlag = true;
                }
            } catch (err) {
                this.msg = "error";
            }
        },
        nickCheck() {// 닉네임 중복검사 이벤트
            try {
                if ("" === this.signup.putnick) {
                    alert("공백 입니다.");
                } else if ("admin" === this.signup.putnick) {
                    alert("이미 가입된 닉네임 입니다.");
                    this.checkNickFlag = false;
                } else {
                    alert("등록 가능한 닉네임 입니다.");
                    this.checkNickFlag = true;
                }
            } catch (err) {
                this.msg = "error";
            }
        },
        passwordValid() {// 비밀번호 유효성 검사 및 플래그
            if (/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,16}$/.test(this.signup.password)) {
                this.passwordValidFlag = true;
                this.checkPwdFlag = true;
            } else {
                this.passwordValidFlag = false;
                this.checkPwdFlag = false;
            }
        },
        passwordCheckValid() { // 비밀번호 재확인 - 비밀번호 일치 여부 검사 및 플래그
            if (this.signup.password === this.passwordCheck) {
                this.passwordCheckFlag = true;
                this.checkRePwdFlag = true;
            } else {
                this.passwordCheckFlag = false;
                this.checkRePwdFlag = false;
            }
        },
        mobileCheckValid() {// 휴대전화번호 유효성 검사 및 플래그
            if (/^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/.test(this.signup.mobile)) {
                  //정규식표현 - 앞자리, 중간자리, 뒷자리 파트별 검사
                this.mobileValidFlag = true;
                this.checkTelFlag = true;
            } else {
                this.mobileValidFlag = false;
                this.checkTelFlag = false;
            }
        },
        submit() {// 회원가입 버튼 이벤트 - 각 컬럼별 유효성 검사
            const checked = document.getElementsByClassName('inputValues')
            for (var i = 0; i < checked.length; i++) {
                if (checked[i].value.length == 0) {
                    alert(`${checked[i].name} 을/를 입력하세요`)
                    checked[i].focus();
                    return;
                }
            }

            if (!this.checkIdFlag) {
                alert("아이디 중복검사를 하세요")
                return;
            }
            if (!this.checkNickFlag) {
                alert("닉네임 중복검사를 하세요")
                return;
            }
            if (!this.checkPwdFlag) {
                alert("비밀 번호를 확인하세요")
                return;
            }
            if (!this.checkRePwdFlag) {
                alert("비밀 번호가 일치 하지 않습니다")
                return;
            }
            if (!this.checkTelFlag) {
                alert("전화번호를 확인하세요")
                return;
            }
            let agreement1 = document.getElementById('agreement1');
            let agreement2 = document.getElementById('agreement2');

            let username = document.getElementById('id').value;
            let password = document.getElementById('pw').value;
            if (!agreement1.checked) {// 약관 - 필수 체크박스 검사
                alert("약관을 확인해 주세요");
            } else if (!agreement2.checked) {
                alert("약관을 확인해 주세요");
            } else {
                alert("회원가입이 완료 되었습니다.");// 모든 컬럼 true 일시 최종적으로 회원가입완료 알람.
                this.$router.push("/");
                this.addMember({
                    username: username,
                    password: password
                })
            }

        },
        execDaumPostcode() {
            new window.daum.Postcode({
                oncomplete: (data) => {
                    if (this.extraAddress !== "") {
                        this.extraAddress = "";
                    }
                    if (data.userSelectedType === "R") {
                        // 사용자가 도로명 주소를 선택했을 경우
                        this.address = data.roadAddress;
                    } else {
                        // 사용자가 지번 주소를 선택했을 경우(J)
                        this.address = data.jibunAddress;
                    }

                    // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                    if (data.userSelectedType === "R") {
                        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                        if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
                            this.extraAddress += data.bname;
                        }
                        // 건물명이 있고, 공동주택일 경우 추가한다.
                        if (data.buildingName !== "" && data.apartment === "Y") {
                            this.extraAddress +=
                                this.extraAddress !== "" ?
                                `, ${data.buildingName}` :
                                data.buildingName;
                        }
                        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                        if (this.extraAddress !== "") {
                            this.extraAddress = `(${this.extraAddress})`;
                        }
                    } else {
                        this.extraAddress = "";
                    }
                    // 우편번호를 입력한다.
                    this.postcode = data.zonecode;
                },
            }).open();
        },
        ...loginStore.mapMutations(["addMember"]),
    },
    computed: {
        ...loginStore.mapGetters(['getUserInfo']),
    }
}
</script>

<style scoped>
.container {
    background-color: #fafafa;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 700px;
}

.container>div {
    width: 750px;
    padding-left: 185px;
}

.container>div>h3 {
    width: 300%;
    margin: 12px 0;
}

.miniBox {
    border: 1px solid;
    border-radius: 4px;
    border-width: 2px;
    border-color: rgb(156, 151, 151);
    padding-top: 35px;
    margin-top: 1px;
    margin-left: 400px;
    margin-right: 400px;
    height: 100px;
    font-size: 18px;
    background-color: #00ba54;
    color: white;
}

.CheckBox {
    text-align: center;
    padding: 10px 0;
}

.CheckBox hr {
    margin-left: 400px;
    margin-right: 400px;
    padding: 1px;
    background-color: rgb(156, 151, 151);
    margin-bottom: 1px;
}

.footer {
    background-color: #fafafa;
}

.joinBtn {
    margin-top: 20px;
}

.joinBtnArea {
    text-align: center;
    padding-bottom: 30px;
}

.inputValues,
.username,
.mobile,
.total_add,
.detail_add {
    text-align: center;
    height: 25px;
    border-radius: 4px;
    border: 1px solid;
    width: 350px;
}

.tempDiv {
    display: flex;
    margin: 40px 0 40px 0;
}

.labelClass {
    min-width: 120px;
    font-weight: bold;
}

.classBtn {
    width: 100px;
    height: 30px;
    margin-left: 10px;
    padding: 0;
}

.pwFlag,
.re_pwFlag {
    margin-top: 0px;
    margin-left: 10px;
    color: red;
}
</style>
