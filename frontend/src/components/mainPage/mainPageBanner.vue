<template>
<div class="banner">
    <div class="test">
        <carousel v-bind="options">
            <!-- // @initialized="init" -->
            <div class="test" v-for="(banners,idx) in bannerImage" :key="idx">
                <img :src="require(`@/assets/bannerImage/${banners.image}`)" alt="banner">
            </div>
        </carousel>
    </div>
</div>
</template>

<script>
import carousel from 'vue-owl-carousel2'
import BannerImage from './banner.json'
export default {
    components: {
        carousel,
    },
    data() {
        return {
            options: {
                autoplay: true,
                items: 1,
                autoplayTimeout: 3000,
                nav: true,
                navText: ["<i class='prev'></i>", "<i class='next'></i>"]
            },
                bannerImage: BannerImage
        }
    }
}
</script>

<style>
.test img {
    height: 450px;
    border-radius: 20px;
}


.prev::after {
    content: '';
    width: 30px;
    /* 사이즈 */
    height: 30px;
    /* 사이즈 */
    border-top: 10px solid #f0ecec;
    /* 선 두께 */
    border-right: 10px solid #f0ecec;
    /* 선 두께 */
    display: inline-block;
    transform: rotate(225deg);
    /* 각도 */
    position: absolute;
    top: 47%;
    left: 30px;
}

.next::after {
    content: '';
    width: 30px;
    /* 사이즈 */
    height: 30px;
    /* 사이즈 */
    border-top: 10px solid #f0ecec;
    /* 선 두께 */
    border-right: 10px solid #f0ecec;
    /* 선 두께 */
    display: inline-block;
    transform: rotate(45deg);
    /* 각도 */
    position: absolute;
    top: 47%;
    right: 30px;
}
</style>
