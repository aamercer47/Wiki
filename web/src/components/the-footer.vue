<template>
  <a-layout-footer style="text-align: center">
    WIKI ©2023 Created by Yuqi Wang<span v-show="user.id">,欢迎：{{user.name}}</span>
  </a-layout-footer>

</template>

<script lang="ts">
import store from '@/store';
import {computed, defineComponent} from 'vue';

  export default defineComponent({
    name: 'the-footer',
    setup(){
      const user = computed(() => store.state.user);

      return {
        user
      }
    }
  });
</script>