<template>
  <transition name="modal-fade">
    <div class="modal-backdrop">
      <div class="modal"
        role="dialog"
        aria-labelledby="modalTitle"
        aria-describedby="modalDescription"
      >
      
      <h3 class="like_heading">Post Likes</h3>
      
        <header
          class="modal-header"
          id="modalTitle"
        >
          <slot name="header">
              <div v-for="like in viewlikes" :key="like.userId" class="head">
            <img :src='like.userDp' class="likeDp"/>
           <p class="likeName">{{like.name}}</p>
              </div>
          </slot>
          <button
            type="button"
            class="btn-close"
            @click="close"
            aria-label="Close modal"
          >
            x
          </button>
        </header>

       

      </div>
    </div>
  </transition>
</template>

<script>
  export default {
    name: 'reModal',
    props: {
        viewlikes: Array
    },
    methods: {
      close() {
        this.$emit('close');
      },
    },
  };
</script>
<style scoped>
  .modal-backdrop {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background-color: rgba(0, 0, 0, 0.3);
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .modal {
    background: #FFFFFF;
    box-shadow: 2px 2px 20px 1px;
    overflow-x: auto;
    display: flex;
    flex-direction: column;
    width: 40%;
    overflow: scroll;
    height: 25%;
    border-radius: 20px;
    text-align: center;
  }

  .modal-header,
  .modal-footer {
    padding: 15px;
    display: flex;
  }

  .modal-header {
    position: relative;
    border-bottom: 1px solid #eeeeee;
    color: #000000;
    justify-content: space-between;
    display: flex;
    flex-direction: column;
  }

  .likeDp{
      border-radius: 100%;
      width: 30px;
      height: 30px;
  }

  .likeName{
      margin-left: 20px;
  }

  .like_heading{
      margin: 10px 0 0 0;
  }

  .head{
      display: flex;
      align-items: center;
      /* justify-content: space-around; */
      /* width: 40%; */
      margin: auto 0 auto 30px ;
  }



  .modal-footer {
    border-top: 1px solid #eeeeee;
    flex-direction: column;
  }


  .btn-close {
    position: absolute;
    top: 0;
    right: 0;
    border: none;
    font-size: 20px;
    padding: 10px;
    cursor: pointer;
    font-weight: bold;
    color: #000000;
    background: transparent;
  }

  .btn-green {
    color: rgb(0, 0, 0);
    background: #ffffff;
    border: 1px solid #000000;
    border-radius: 2px;
  
  }

  .modal-fade-enter,
  .modal-fade-leave-to {
    opacity: 0;
  }

  .modal-fade-enter-active,
  .modal-fade-leave-active {
    transition: opacity .5s ease;
  }

  @media (max-width:480px) {
    .modal{
        width: 80%;
    }
}


  @media (max-width:320px) {
    .modal{
        width: 80%;
    }
}
</style>