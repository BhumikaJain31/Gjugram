<template>
  <div>
    <navBar />

    <div class="feed">
     
      <div>
        <div class="userFeed">
          <div class="feeds" v-for="post in postDetails.slice().reverse()" :key="post.id">
            <div class="userDetails">
              <div @click="handleUserClick(post.userProfileDetails.userId)" class="details">
                <img :src="post.userProfileDetails.userDp" alt="" class="dp" />
                <div>
                  <h4>{{ post.userProfileDetails.name }}</h4>
                </div>
              </div>

              <div>
                <p>{{post.postsEntity.timestamp.slice(11,16)}}</p>
              </div>
            </div>
            <div>
              <img :src="post.postsEntity.mediaType" alt="" class="post" />
            </div>
            <div class="input">
              <h3 class="in"
                  @click="
                    handleLike(
                      post.userProfileDetails.userId,
                      post.postsEntity.id,
                      user.id,
                      user.name,
                      post.userProfileDetails.email
                    )
                  "
                >
                  Like
                </h3>
              
              <h3 class="in" @click="
                toggle();
                showComment(post.postsEntity.id);
              ">Comment</h3>
              <h3 class="in" @click="addSaved(post.postsEntity.id)">Save</h3>
            </div>
            <div class="show_all">
                <p  class="show"
                @click="showModal();
                  viewLikes(post.userProfileDetails.userId, post.postsEntity.id)
                "
              >
                View Likes
              </p>
             <p class="show"
              @click="
                toggle();
                showComment(post.postsEntity.id);
              "
            >
              Show comments
            </p>
            
            </div>
            <div class="input comment">
              <input
                v-model="comment"
                placeholder="Enter the comment"
                class="comments"
              />
              <p

                @click="handleComment(post.userProfileDetails.userId,post.postsEntity.id,user.name,
                      post.userProfileDetails.email)"
                class="add_comment "
              >
                Add
              </p>
            </div>
           
            <div v-for="comment1 in comments" :key="comment1.id">
              <div v-if="post.postsEntity.id == comment1.postId">
                <div id="modal" v-show="displayModal">
                  <div>
                    <div v-for="comment in comments" :key="comment.id">
                      <div
                        v-if="comment1.id == comment.id"
                        class="comment_post"
                      >
                        <img :src="comment.userDp" class="comment_image" />
                        <div class="all_details">
                          <h4>{{ comment.userName }}</h4>
                          <p>{{ comment.comment }}</p>
                          <div
                            v-for="reply in comment.replyList"
                            :key="reply.userId"
                            class="reply_class"
                          >
                            <img :src="reply.userDp" class="reply_image" />
                            <div class="all_details">
                              <h5>{{ reply.userName }}</h5>
                              <p>{{ reply.reply }}</p>
                            </div>
                          </div>
                          <div class="reply">
                            <input
                              v-model="reply"
                              placeholder="Enter the reply"
                              class="hi"
                              :v-bind="comment.id"
                            />
                            <p
                            class="re"
                              @click="
                                handleReply(post.postsEntity.id, comment.id)
                              "
                            >
                              Reply
                            </p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

          </div>
        </div>
      <!-- <div class="ads user_profile">
          <img :src="ads[randomNumber()].image" class="post"/>
          
      </div>
      <div class="userFeed">
          <div class="feeds" v-for="post in postDetails.slice(5,10).reverse()" :key="post.id">
            <div class="userDetails">
              <div @click="handleUserClick(userDetails.userId)" class="details">
                <img :src="post.userProfileDetails.userDp" alt="" class="dp" />
                <div>
                  <h4>{{ post.userProfileDetails.name }}</h4>
                </div>
              </div>

              <div>
                <p>{{post.postsEntity.timestamp.slice(11,16)}}</p>
              </div>
            </div>
            <div>
              <img :src="post.postsEntity.mediaType" alt="" class="post" />
            </div>
            <div class="input">
              <h3 class="in"
                  @click="
                    handleLike(
                      post.userProfileDetails.userId,
                      post.postsEntity.id,
                      user.id,
                      user.name,
                      post.userProfileDetails.email
                    )
                  "
                >
                  Like
                </h3>
              
              <h3 class="in" @click="
                toggle();
                showComment(post.postsEntity.id);
              ">Comment</h3>
              <h3 class="in" @click="addSaved(post.postsEntity.id)">Save</h3>
            </div>
            <div class="show_all">
                <p  class="show"
                @click="showModal();
                  viewLikes(post.userProfileDetails.userId, post.postsEntity.id)
                "
              >
                View Likes
              </p>
             <p class="show"
              @click="
                toggle();
                showComment(post.postsEntity.id);
              "
            >
              Show comments
            </p>
            
            </div>
            <div class="input comment">
              <input
                v-model="comment"
                placeholder="Enter the comment"
                class="comments"
              />
              <p

                @click="handleComment(post.userProfileDetails.userId,post.postsEntity.id,user.name,
                      post.userProfileDetails.email)"
                class="add_comment "
              >
                Add
              </p>
            </div>
           
            <div v-for="comment1 in comments" :key="comment1.id">
              <div v-if="post.postsEntity.id == comment1.postId">
                <div id="modal" v-show="displayModal">
                  <div>
                    <div v-for="comment in comments" :key="comment.id">
                      <div
                        v-if="comment1.id == comment.id"
                        class="comment_post"
                      >
                        <img :src="comment.userDp" class="comment_image" />
                        <div class="all_details">
                          <h4>{{ comment.userName }}</h4>
                          <p>{{ comment.comment }}</p>
                          <div
                            v-for="reply in comment.replyList"
                            :key="reply.userId"
                            class="reply_class"
                          >
                            <img :src="reply.userDp" class="reply_image" />
                            <div class="all_details">
                              <h5>{{ reply.userName }}</h5>
                              <p>{{ reply.reply }}</p>
                            </div>
                          </div>
                          <div class="reply">
                            <input
                              v-model="reply"
                              placeholder="Enter the reply"
                              class="hi"
                              :v-bind="comment.id"
                            />
                            <p
                            class="re"
                              @click="
                                handleReply(post.postsEntity.id, comment.id)
                              "
                            >
                              Reply
                            </p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

          </div>
        </div>
      <div class="ads user_profile">
          <img :src="ads[randomNumber()].image" class="post"/>
          
      </div>
              <div class="userFeed">
          <div class="feeds" v-for="post in postDetails.slice(0,5).reverse()" :key="post.id">
            <div class="userDetails">
              <div @click="handleUserClick(userDetails.userId)" class="details">
                <img :src="post.userProfileDetails.userDp" alt="" class="dp" />
                <div>
                  <h4>{{ post.userProfileDetails.name }}</h4>
                </div>
              </div>

              <div>
                <p>{{post.postsEntity.timestamp.slice(11,16)}}</p>
              </div>
            </div>
            <div>
              <img :src="post.postsEntity.mediaType" alt="" class="post" />
            </div>
            <div class="input">
              <h3 class="in"
                  @click="
                    handleLike(
                      post.userProfileDetails.userId,
                      post.postsEntity.id,
                      user.id,
                      user.name,
                      post.userProfileDetails.email
                    )
                  "
                >
                  Like
                </h3>
              
              <h3 class="in" @click="
                toggle();
                showComment(post.postsEntity.id);
              ">Comment</h3>
              <h3 class="in" @click="addSaved(post.postsEntity.id)">Save</h3>
            </div>
            <div class="show_all">
                <p  class="show"
                @click="showModal();
                  viewLikes(post.userProfileDetails.userId, post.postsEntity.id)
                "
              >
                View Likes
              </p>
             <p class="show"
              @click="
                toggle();
                showComment(post.postsEntity.id);
              "
            >
              Show comments
            </p>
            
            </div>
            <div class="input comment">
              <input
                v-model="comment"
                placeholder="Enter the comment"
                class="comments"
              />
              <p

                @click="handleComment(post.userProfileDetails.userId,post.postsEntity.id,user.name,
                      post.userProfileDetails.email)"
                class="add_comment "
              >
                Add
              </p>
            </div>
           
            <div v-for="comment1 in comments" :key="comment1.id">
              <div v-if="post.postsEntity.id == comment1.postId">
                <div id="modal" v-show="displayModal">
                  <div>
                    <div v-for="comment in comments" :key="comment.id">
                      <div
                        v-if="comment1.id == comment.id"
                        class="comment_post"
                      >
                        <img :src="comment.userDp" class="comment_image" />
                        <div class="all_details">
                          <h4>{{ comment.userName }}</h4>
                          <p>{{ comment.comment }}</p>
                          <div
                            v-for="reply in comment.replyList"
                            :key="reply.userId"
                            class="reply_class"
                          >
                            <img :src="reply.userDp" class="reply_image" />
                            <div class="all_details">
                              <h5>{{ reply.userName }}</h5>
                              <p>{{ reply.reply }}</p>
                            </div>
                          </div>
                          <div class="reply">
                            <input
                              v-model="reply"
                              placeholder="Enter the reply"
                              class="hi"
                              :v-bind="comment.id"
                            />
                            <p
                            class="re"
                              @click="
                                handleReply(post.postsEntity.id, comment.id)
                              "
                            >
                              Reply
                            </p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

          </div>
        </div> -->

    <reModal
      v-show="isModalVisible"
      @close="closeModal"
      :viewlikes="viewlikes"
    />

        
      </div>
    </div>
    <footerBar />
  </div>
</template>

<script>
  import reModal from './reModal.vue';
import navBar from "./navBar.vue";
import footerBar from './footerBar.vue'
export default {
  name: "userFeed",
  components: {
    navBar,reModal,footerBar
  },
  template: "#item",
  data() {
    return {
      user: {},
      postDetails: [],
      sortedActivities: [],
      comment: "",
      displayModal: false,
      comments: [],
      reply: "",
      displayButton: false,
      auth: '',
      ads: [],
      isModalVisible: false,
      viewlikes: [],
      
    };
  },
  created() {
     

    if (sessionStorage.getItem("User")) {
      this.user = JSON.parse(sessionStorage.getItem("User"));
    }

    

    this.axios
      .get(`http://localhost:8083/user-post/user-feed?userId=${this.user.id}`).then((resp) => {
          this.postDetails = resp.data
        this.postDetails = this.postDetails.sort(function (var1, var2) { 
   var a= new Date(var1.postsEntity.timestamp), b = new Date(var2.postsEntity.timestamp);
  
    if (a > b)
      return 1;
    if (a < b)
      return -1;
   
    return 0;
});
      })

      

      this.axios.get(`http://10.20.2.212:8082/Ads/getAds?Username=${this.user.userName}`).then((resp) =>{
          this.ads = resp.data.data
      })
  },
  methods: {
            showModal() {
        this.isModalVisible = true;
      },
      closeModal() {
        this.isModalVisible = false;
      },

    handleLike(userId, postId, likerId, userName, to) {
      //userId, postId, likerId
      let arr = this.postDetails;
      console.log(arr);
      this.axios.put(
        `http://localhost:8082/post/update-likes?userId=${userId}&postId=${postId}&likerId=${likerId}`
      ).then(() =>{
          this.tlike();
          this.addNotification(likerId,userId);
          this.axios.post('http://10.20.2.201:8081/liked',{
            app: "Quinstagram",
            username: userName,
            to: to,
            subject: "",
            message: ""
          })
      });
    },
    viewLikes(userId, postId) {
      this.axios
        .get(
          `http://localhost:8082/post/view-likes?userId=${userId}&postId=${postId}`
        )
        .then((resp) => {
          this.viewlikes = resp.data;
        });
    },

    handleComment(userId,postId,userName,to) {
        if(this.comment != ""){
      this.axios
        .post(
          `http://localhost:8082/post/add-comment?userId=${this.user.id}&postId=${postId}&comment=${this.comment}`
        ).then(() => {
             this.tadd();
             this.addNotificationForComment(this.user.id,userId);
             this.axios.post('http://10.20.2.201:8082/comment',{
            app: "Quinstagram",
            username: userName,
            to: to,
            subject: "",
            message: ""
          })
        })
        
      this.comment = "";
      
    }},

    showComment(postId) {
      this.axios
        .get(`http://localhost:8082/post/fetch-comments?postId=${postId}`)
        .then((resp) => {
          this.comments = resp.data;
        });
    },

    toggle() {
      this.displayModal = !this.displayModal;
    },

    toggleButton() {
      this.displayButton = !this.displayButton;
    },

    handleReply(postId, cid) {
      this.axios
        .post(
          `http://localhost:8082/post/add-reply?userId=${this.user.id}&postId=${postId}&commentId=${cid}&reply=${this.reply}`
        )
        .then(() => {
        this.showComment(postId)
        });
      this.reply = "";
    },
    tadd(){
        this.$toasted.show("Comment Added")
    },
    tsave(){
        this.$toasted.show("Saved")
    },
    tlike(){
        this.$toasted.show("Liked")
    },
    randomNumber : function(){
      return Math.floor(Math.random() * 10) + 1;
    },

    addNotification(uid,fid){
      this.axios.post(`http://localhost:8083/user-post/add-to-notification?userId=${uid}&postUserId=${fid}&notificationType=like`
      )},

    addNotificationForComment(uid,fid){
      this.axios.post(`http://localhost:8083/user-post/add-to-notification?userId=${uid}&postUserId=${fid}&notificationType=comment`
      )},
      handleUserClick(userId){
            this.$router.push(`userDetails/${userId}`)
        },

      addSaved(pid){
        this.axios.post(`http://localhost:8082/post/add-to-saved?userId=${this.user.id}&postId=${pid}`).then(() => {
            this.tsave();
          })
      }
  },
  
};
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


