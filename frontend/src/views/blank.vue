<template>
<div class="blank">
    <div class="container">
        <h1 class="title">빈 페이지</h1>
        <!-- <router-link v-bind:to="'/'"> -->
        <h1 class="content" @click="hasHistory() 
    ? $router.go(-1) 
    : $router.push('/')">돌아가기</h1>
        <!-- </router-link> -->
    </div>
</div>
</template>

<script>
export default {
    methods: {
        hasHistory() {
            return window.history.length > 2
        }
    }
}
</script>

<style scoped>
.blank .container {
    display: block;
    height: 1000px;
}

.blank .content {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    color: rgb(0, 153, 255);
}

.title {
    text-align: center;
}

.content:hover{
    cursor: pointer;
}
</style>
