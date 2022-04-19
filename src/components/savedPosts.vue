<template>
  <div>
    <navBar />

    <div class="feed">
     
      <div>
        <div class="userFeed">
          <div class="feeds" v-for="post in response.slice().reverse()" :key="post.id">
            <div class="userDetails">
              <div @click="handleUserClick(post.postUserId)" class="details">
                <img :src="post.postUserDp" alt="" class="dp" />
                <div>
                  <h4>{{ post.postUsername }}</h4>
                </div>
              </div>

             
            </div>
            <div>
              <img :src="post.postImage" alt="" class="post" />
            </div>

          </div>
        </div>
      

    
        
      </div>
    </div>
    <footerBar />
  </div>
</template>

<script>
import navBar from './navBar.vue'
import footerBar from './footerBar.vue'
export default {
name:'savedPosts',
components: {
   navBar,footerBar
},
data(){
    return{
        user: {},
        response: [],
        auth: ''
    }
},
created() {
        

    if (sessionStorage.getItem("User")) {
      this.user = JSON.parse(sessionStorage.getItem("User"));
    }

        this.axios.get(`http://localhost:8082/post/fetch-all-saved?userId=${this.user.id}`).then(
            (resp) => {
                this.response = resp.data
            }
        )
    
},
methods: {
     handleUserClick(userId){
            this.$router.push(`userDetails/${userId}`)
        },
}
}
</script>

<style scoped>
.comment_post {
  display: flex;
  /* align-items: center; */
  background-color: #fff;
  margin-bottom: 15px;
}

.add_comment{
    margin: 0 20px 0 0;
    padding: 5px;
    background-color: #fff;
    font-weight: bold;
}

.reply_class {
  display: flex;
  align-items: center;
}

.all_details {
  line-height: 5px;
  margin-left: 20px;
}

.all_details > h4 {
  margin-left: 0px;
}
.comment_image {
  width: 50px;
  height: 50px;
  border-radius: 100%;
  margin: 10px 0 0 10px;
}

.story {
  border-radius: 100%;
  width: 60px;
  height: 60px;
  margin: 20px 12px;
}

.show{
    margin: 0px;
    padding: 5px;
    background-color: #fff;
}

.input > h3{
    margin: 5px;
}

.show_all{
    display: flex;
    justify-content: space-around;
    background-color: #fff;
    margin: 0 15px;
}
.userStory {
  display: flex;
  overflow: scroll;
  background-color: #fff;
  width: 90%;
  margin: 10px auto;
  border: 1px solid rgb(211, 209, 209);
  border-radius: 5px;
}

.feeds {
  margin: 15px auto;
  border: 1px solid rgb(211, 209, 209);
  border-radius: 8px;
  overflow: hidden;
  background-color: #fff;
}

.feed {
  width: 70%;
  margin: 80px auto ;
}

.userDetails {
  display: flex;
  align-items: center;
  justify-content: space-between;
  background-color: #fff;
  padding: 10px;
}

.userFeed {
  width: 90%;
  margin: 20px auto;
  /* background-color: #fff; */
  border-radius: 10px;
  overflow: hidden;
}

.ads {
  width: 90%;
  margin: 20px auto;
  background-color: #fff;
  border-radius: 10px;
  overflow: hidden;
  text-align: center;
}

.re{
    font-size: 14px;
    font-weight: bold;
}

.dp {
  height: 50px;
  width: 50px;
  border-radius: 100%;
}

h4 {
  margin-left: 10px;
}

.details {
  display: flex;
  align-items: center;
  cursor: pointer;
}

.post {
  width: 100%;
  height: 500px;
}

.input {
  display: flex;
  align-items: center;
  justify-content: space-around;
  background-color: #fff;
}

.comments {
  margin: 10px 5px 20px 20px;
  font-size: 18px;
  width: 100%;
  border: none;
  border-bottom: 1px solid rgb(122, 121, 121);
  padding-top: 15px;
}

.hi{  
    font-size: 14px;
    border: none;
  border-bottom: 1px solid rgb(122, 121, 121);
}

.reply_image {
  width: 25px;
  height: 25px;
  border-radius: 100%;
}

.reply{
    display: flex;
}

.re, .add_comment, .show, .in{
    cursor: pointer;
}
@media screen and (max-width: 790px) {
  .post {
    height: 400px;
  }
}

@media screen and (max-width: 650px) {
  .post {
    height: 300px;
  }
}

@media screen and (max-width: 570px) {
  .post {
    height: 300px;
  }

  .userStory {
    width: 100%;
  }

  .userFeed {
    width: 100%;
  }
  .feed {
    width: 100%;
  }

  .story {
    margin: 10px 12px;
  }

  .userDetails {
    padding: 0 10px;
  }
}
</style>