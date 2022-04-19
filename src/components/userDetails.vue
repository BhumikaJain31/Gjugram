<template>
  <div>
    <navBar />
    <div class="user_profile">
      <div>
        <div class="user_data">
          <img :src="user.userDp" alt="" class="display_picture" />
          <div>
            <div class="all_details">
                <div class="user">
              <h2 class="user_name">{{ user.userName }}</h2>
              <div  v-if="this.user.accType == 'private'">
              <button @click="updateRequestList(userDetails.id, user.userId)" class="btn">
            Follow
          </button>
          </div>
          <div v-else>
          <button @click="handleFollow(userDetails.id, user.userId)" class="btn">
            Follow 
          </button>
          </div>
                </div>
              <div class="user_details">
                <div v-if="this.posts == null">
                  <p class="pff"><span class="detail_number">0</span>Posts</p>
                </div>
                <div v-else>
                  <p class="pff">
                    <span class="detail_number">{{ this.posts.length }}</span
                    >Posts
                  </p>
                </div>
                <div v-if="this.user.userFollowers == null">
                  <p class="pff">
                    <span class="detail_number">0</span>Followers
                  </p>
                </div>
                <div v-else>
                  <p class="pff">
                    <span class="detail_number">{{
                      this.user.userFollowers.length
                    }}</span
                    >Followers
                  </p>
                </div>
                <div v-if="this.user.userFollowing == null">
                  <p class="pff">
                    <span class="detail_number">0</span>Following
                  </p>
                </div>
                <div v-else>
                  <p class="pff">
                    <span class="detail_number">{{
                      this.user.userFollowing.length
                    }}</span
                    >Following
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div>
          <h4>{{ user.name }}</h4>
          <p>{{ user.userBio }}</p>
          
        </div>
      </div>
      <hr />
      <div>
        <div v-if="this.user.accType == 'private'">
          <div v-for="followers in this.user.userFollowers" :key="followers.id">
            <div v-if="userDetails.id == followers">
              <div class="user_posts">
                <div v-for="post in posts" :key="post.id">
                  <div class="content">
                    <div class="content-overlay"></div>
                    <img class="content-image" :src="post.mediaType" />
                    <div class="content-details">
                      <h3>🤍</h3>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div v-else>
          <div class="user_posts">
            <div v-for="post in posts" :key="post.id">
              <div class="content">
                <div class="content-overlay"></div>
                <img class="content-image" :src="post.mediaType" />
                <div class="content-details">
                  <h3>🤍</h3>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <footerBar/>
  </div>
</template>

<script>
import navBar from "./navBar.vue";
import footerBar from './footerBar.vue'

export default {
  name: "userDetails",
  components: {
    navBar,footerBar
  },

  created() {
     

     
    const userId = this.$route.params.userId;
    this.axios
      .get(
        `http://localhost:8083/user-post/get-user-profile-details?userId=${userId}`
      )
      .then((resp) => {
        this.user = resp.data;

        this.axios
          .get(`http://localhost:8082/post/get-user-post?userId=${userId}`)
          .then((resp) => {

            this.posts = resp.data;
          });
      });

    if (sessionStorage.getItem("User")) {
      this.userDetails = JSON.parse(sessionStorage.getItem("User"));
    }
  },
  data() {
    return {
      user: {},
      posts: [],
      userDetails: {},
      auth: ''
    };
  },

  methods: {
    handleFollow(uid, fid) {
      this.axios.put(
        `http://localhost:8083/user-post/update-following-list?userId=${uid}&followingId=${fid}`
      ).then(()=> {
          this.nowFollowing()
      
      });
    },

    updateRequestList(uid, fid){
        this.axios.put(`http://localhost:8083/user-post/update-request-list?userId=${uid}&followingId=${fid}`
        ).then(() => {
            this.requestSent()
        })},
    
    nowFollowing(){
        this.$toasted.show("Following this account")
        this.$router.go()
    },

    requestSent(){
        this.$toasted.show("Follow Request Sent")
    },

  },

};
</script>

<style scoped>
.user_profile {
  width: 70%;
  margin: 80px auto 0 auto;
}
.posts {
  margin: 10px;
  height: 200px;
  width: 200px;
}

.user_data {
  display: flex;
}

.user{
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

.display_picture {
  width: 150px;
  height: 150px;
  border-radius: 100%;
}

.user_details {
  display: flex;
}

.all_details {
  line-height: 25px;
  margin-left: 80px;
}

.pff {
  margin: 0 40px 0 0;
  font-size: 18px;
}

.detail_number {
  margin: 0 7px 0 0;
  font-weight: bold;
}

.user_btn {
  /* width: 48%; */
  padding: 10px;
  border-radius: 5px;
  border: none;
  margin: 0 10px 0 0;
  color: #fff;
  background-color: #0095f6;
  font-size: 15px;
  font-weight: bold;
  cursor: pointer;
}

.user_posts {
  text-align: center;
  display: flex;
  justify-content: center;
  width: 90%;
  margin: auto;
  flex-flow: row wrap;
}

.content {
  position: relative;
  width: 250px;
  height: 250px;
  margin: 10px;
  cursor: pointer;
}

.btn{
    padding: 7px 10px;
      margin: 0 10px 0 0;
      font-size: 15px;
      font-weight: bold;
      cursor: pointer;
      background-color: #0095f6;
    border: solid 1px rgba(228, 228, 228, 0);
    border-radius: 5px;
    color: rgb(255, 255, 255);
}


.content .content-overlay {
  background: rgba(0, 0, 0, 0.7);
  position: absolute;
  height: 99%;
  width: 100%;
  left: 0;
  top: 0;
  bottom: 0;
  right: 0;
  opacity: 0;
  -webkit-transition: all 0.4s ease-in-out 0s;
  -moz-transition: all 0.4s ease-in-out 0s;
  transition: all 0.4s ease-in-out 0s;
}

.content:hover .content-overlay {
  opacity: 1;
}

.content-image {
  width: 250px;
  height: 250px;
}

.content-details {
  position: absolute;
  text-align: center;
  padding-left: 1em;
  padding-right: 1em;
  top: 50%;
  left: 50%;
  opacity: 0;
  -webkit-transform: translate(-50%, -50%);
  -moz-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  -webkit-transition: all 0.3s ease-in-out 0s;
  -moz-transition: all 0.3s ease-in-out 0s;
  transition: all 0.3s ease-in-out 0s;
}

.content:hover .content-details {
  top: 50%;
  left: 50%;
  opacity: 1;
}

.content-details h3 {
  color: #fff;
  font-weight: 500;
  letter-spacing: 0.15em;
  margin-bottom: 0.5em;
}

@media (max-width: 767px) {
  .user_name {
    font-size: 20px;
    margin: 5px 0;
  }

  .display_picture {
    height: 70px;
    width: 70px;
  }

  .user_profile {
    margin: 80px auto;
    width: 80%;
  }

  .all_details {
    margin: 0 0 0 15px;
  }

  .pff {
    margin: 5px;
    font-size: 16px;
  }

  p {
    font-size: 15px;
  }

  .user_btn {
    width: 47%;
    padding: 8px;
  }

  .content {
    width: 160px;
    height: 160px;
    margin: 5px;
  }

  .user_posts {
    width: 100%;
  }

  .content-image {
    width: 160px;
    height: 160px;
  }
}

@media (max-width: 480px) {
  .user_name {
    font-size: 20px;
    margin: 5px 0;
  }

  .display_picture {
    height: 70px;
    width: 70px;
  }

  .user_profile {
    margin: 80px auto;
    width: 100%;
  }

  .all_details {
    margin: 0 0 0 15px;
  }

  .pff {
    margin: 5px;
    font-size: 16px;
  }

  p {
    font-size: 15px;
  }

  .user_btn {
    width: 47%;
    padding: 8px;
  }

  .content {
    width: 130px;
    height: 130px;
    margin: 5px;
  }

  .user_posts {
    width: 100%;
  }

  .content-image {
    width: 130px;
    height: 130px;
  }
}

@media (max-width: 320px) {
  .user_name {
    font-size: inherit;
    margin: 5px 0;
  }

  .display_picture {
    height: 60px;
    width: 60px;
  }

  .user_profile {
    margin: 80px auto;
    width: 100%;
  }

  .all_details {
    margin: 0 0 0 15px;
  }

  .pff {
    margin: 5px;
    font-size: 14px;
  }

  p {
    font-size: 12px;
  }

  .user_btn {
    width: 40%;
    padding: 8px;
  }

  .content {
    width: 100px;
    height: 100px;
    margin: 3px;
  }

  .user_posts {
    width: 100%;
  }

  .content-image {
    width: 100px;
    height: 100px;
  }
}
</style>





