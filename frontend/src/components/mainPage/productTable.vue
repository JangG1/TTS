<template>
<div class="main">
    <!-- 배너영역 -->
    <div class="banner">
        <bannerImage />
    </div>
    <div></div>
    <!-- 메인 화면에 이미지를 출력하는 기능 -->
    <div>
        <div class="imageArea">
            <div class="card_image" v-for='(idx) in limitLength' :key="idx">
                <!-- <p>{{images[idx-1].link}}</p> -->
                <div class="imageDiv">
                    <router-link v-bind:to="'/store'">
                        <img :src="setImage(idx)" >
                    </router-link>
                </div>
                
            </div>
        </div>
    </div>
</div>
</template>

<script>
import axios from 'axios'
// import imageJson from './image.json'
import bannerImage from '@/components/mainPage/mainPageBanner.vue'
export default {
    data() {
        return {
            limitLength: 0,
            imageLength: 0,
            images: []
        }
    },
    components: {
        bannerImage
    },
    methods: {
        setImage(idx) {
            try {
                return require(`@/components/mainPage/categoryImage/${this.images[idx-1].image}`)
            } catch {
                return require(`@/components/mainPage/categoryImage/error.png`)
            }
        },
        async getImagesData() {
            await axios.get("/api/category/all").then(res => {
                this.data = res.data;
                this.data.forEach(element => {
                    let temp = {
                        image: element.image,
                        MenuCategory: element.MenuCategory,
                        link: '/category/'+element.menuNo,
                    }
                    this.images.push(temp);
                });
                this.imageLength = this.images.length;
                if (this.imageLength > 12)
                    this.limitLength = 12;
                else
                    this.limitLength = this.imageLength;
            })
        }
    },
    mounted() {
        this.getImagesData();

    }

}
</script>

<style scoped>
.banner img {
    max-width: 100%;
    height: auto;
}



.imageArea {
    display: flex;
    flex-wrap: wrap;
    text-align: center;
    margin-left: 180px;
    margin-top: 30px;
}

.card_image {
    margin-bottom: 10px;
    border-radius: 8px;
}

.card_image:nth-child(4n-3) {
    border: 1px solid black;
    margin-right: 10px;
}

.card_image:nth-child(4n-2) {
    border: 1px solid black;
    margin-left: 1px;
    margin-right: 10px;
}

.card_image:nth-child(4n-1) {
    border: 1px solid black;
    margin-left: 1px;
    margin-right: 10px;
}

.card_image:nth-child(4n) {
    border: 1px solid black;
    margin-left: 1px;
    margin-right: 0;
}


.card_image>.imageDiv {
    width: 280px;
    height: 250px;
    overflow: hidden;
    margin-top: 0px;
    margin-bottom: 0px;
    border-radius: 8px;
}

.imageDiv img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}





/*  */
</style>
