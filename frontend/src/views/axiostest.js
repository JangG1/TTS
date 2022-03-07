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
            axios.get('api/tts/axios')
                .then((response) => {
                    this.tests = response.data
                })
        },
        getMp3(){
            const { data } = 
            axios.get(url, {
        responseType: 'arraybuffer',
        headers: {
            'Content-Type': 'audio/wav'
        }
      });
const blob = new Blob([data], {
          type: 'audio/wav'
      });

const url = URL.createObjectURL(blob);
        }
    },
    created() {
        this.getData();
        this.getMp3();
    },
}