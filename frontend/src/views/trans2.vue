<template>
  <div>
    <div v-on:click="googleLogin">
      <img style="width: 46px; height: 46px" src="@/assets/googleLogo.png" />
    </div>
    <div id="my-signin2" style="display: none"></div>
    <div v-on:click="kakaoLogin">
      <img style="width: 46px; height: 46px" src="@/assets/kakaoLogo.png" />
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "App",
  components: {},
  data() {
    return {
      googleAuth: null,
    };
  },
  created() {
    window.Kakao.init("1f97c7785977d78aa615deb41e557844");
  },
  methods: {
    kakaoLogin() {
      // console.log(window.Kakao);
      window.Kakao.Auth.login({
        scope: "profile_image, account_email",
        success: this.kakaoInfo,
      });
    },
    async kakaoInfo(authObj) {
      console.log(authObj);
      window.Kakao.API.request({
        url: "/v2/user/me",
        success: (res) => {
          const kakao_account = res.kakao_account;
          const userInfo = {
            email: kakao_account.email,
            profile: kakao_account.profile,
          };
          axios
            .get("/api/user/" + userInfo.email)
            .then((res) => {
              console.log("인증성공 ");
              console.log(userInfo);
              console.log(res);
              if (userInfo.email != null || userInfo.email != "") {
                axios
                  .post("/api/user/save/normal", JSON.stringify(userInfo), {
                    headers: { "Content-Type": `application/json` },
                  })
                  .then((res) => {
                    res;
                    console.log("가입성공");
                  })
                  .catch((err) => {
                    err;
                    console.log("가입에러");
                  });
              }
            })
            .catch((err) => {
              err;
              console.log("인증에러");
            });
          alert("로그인 성공!");
        },
        fail: (error) => {
          this.$router.push("/errorPage");
          console.log(error);
        },
      });
    },
    /*kakaoLogout() {
      // eslint-disable-next-line
      if (!Kakao.Auth.getAccessToken()) {
        console.log("Not logged in.");
        return;
      }
      Kakao.Auth.logout(function (response) {
        alert(response + "logout");
        window.location.href = "/";
      });
      localStorage.clear(); // 전체삭제
    },
*/
    //구글 버튼
    googleLogin() {
      var self = this;
      window.gapi.signin2.render("my-signin2", {
        scope: "profile email",
        width: 240,
        height: 50,
        longtitle: true,
        theme: "dark",
        onsuccess: this.googleInfo,
        onfailure: this.googleLogout,
      });
      setTimeout(function () {
        if (!self.googleLoginCheck) {
          const auth = window.gapi.auth2.getAuthInstance();  
          auth.isSignedIn.get();
          document.querySelector(".abcRioButton").click();
        }
      }, 500);
    },
    //구글 로그인 이후 실행되는 콜백함수(성공)
    async googleInfo(googleUser) {
      //const user_join_type = "g"
      const profile = googleUser.getBasicProfile();
      const googleEmail = profile.getEmail();
      const googleProfile = profile.getImageUrl();

      let googleData = {};
      googleData.email = googleEmail;
      googleData.profile = googleProfile;
      await axios
        .get("/api/user/" + googleEmail)
        .then((res) => {
          console.log("인증성공 ");
          console.log(googleData);
          if (res.data == null || res.data == "") {
            axios
              .post("/api/user/save/normal", JSON.stringify(googleData), {
                headers: { "Content-Type": `application/json` },
              })
              .then((res) => {
                res;
                console.log("가입성공");
              })
              .catch((err) => {
                err;
                console.log("가입에러");
              });
          }
        })
        .catch((err) => {
          err;
          console.log("인증에러");
        });
    },
    googleLogout() {
      // eslint-disable-next-line
      const auth = gapi.auth2.getAuthInstance();
      auth.signOut().then(function () {
        console.log("User signed out.");
      });
      localStorage.clear();
    },
  },
};
</script>
