<template>
  <div class="blogpost" :class="{heighlighted: post.heighlighted}">
    <h2>{{post.title}}</h2>
    <p>{{post.body}}</p>
    <p class="meta">written by {{post.author}} on {{post.date}}</p>
    <p v-if="post.heighlighted">This post is heighlighted!</p>
  </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

export interface Post {
  title: string;
  body: string;
  author: string;
  datePosted: Date;
  heighlighted ?: boolean;
}

@Component
export default class BlogPost extends Vue {
  // 若为post请求，则post不为null或undefined
  @Prop() private post!: Post;

  get date() {
    return {}
    // return `${this.post.datePosted.getDate()}/${this.post.datePosted.getMonth()}/${this.post.datePosted.getFullYear()}`;
  }
}
</script>
<style lang="stylus">
.blogpost
  &.heighlighted
    border 1px solid #f4d942
    background-color #abe
  h2
    text-decoration underline
  .meta
    font-style italic
</style>
