<template>
  <div class="app-container ">
    <div v-show="loaded < 100" style="text-align: center">
      <el-progress type="circle" :percentage="loaded"></el-progress>
    </div>
    <div class="scene" ref="scene" height="100px">
    </div>
  </div>
</template>

<script>
import * as THREE from "three"
import Stats from 'three/examples/jsm/libs/stats.module.js';
import { OrbitControls } from "three/examples/jsm/controls/OrbitControls"
import { RoomEnvironment } from 'three/examples/jsm/environments/RoomEnvironment.js';

import { GLTFLoader } from "three/examples/jsm/loaders/GLTFLoader"

import { DRACOLoader } from 'three/examples/jsm/loaders/DRACOLoader.js';

export default {
  name: "Scene",
  data: function () {
    return {
      scene: undefined,
      renderer: undefined,
      camera: undefined,
      loaded: 0
    };
  },
  methods: {
    init () {
      /**
       * 创建场景对象Scene
       */
      this.scene = new THREE.Scene();
      this.scene.background = new THREE.Color(0xffffff)

      // Renderer
      this.renderer = new THREE.WebGLRenderer({ antialias: true })
      this.renderer.physicallyCorrectLights = true;
      this.renderer.setSize(this.$refs.scene.clientWidth, this.$refs.scene.clientHeight)

      this.$refs.scene.appendChild(this.renderer.domElement)

      // Camera
      const aspect = this.$refs.scene.clientWidth / this.$refs.scene.clientHeight
      this.camera = new THREE.PerspectiveCamera(50, aspect, 0.1, 500)
      this.camera.position.set(-3, 3, 7)
      this.camera.rotation.y = (150 / 180) * Math.PI

      new OrbitControls(this.camera, this.renderer.domElement); //创建控件对象

      const loader = new GLTFLoader()
      console.log(loader)
      loader.load("/module/house/scene.gltf", (result) => {
        console.log(this)
        this.scene.add(result.scene)
        this.animate()
      }, xhr => {
        this.loaded = Math.floor(xhr.loaded / xhr.total * 100)
      })


      // let mixer;
      //
      // const clock = new THREE.Clock();
      // const container = document.getElementById( 'container' );
      //
      // const stats = new Stats();
      // container.appendChild( stats.dom );
      //
      // const renderer = new THREE.WebGLRenderer( { antialias: true } );
      // renderer.setPixelRatio( this.$refs.scene.devicePixelRatio );
      // renderer.setSize( this.$refs.scene.clientWidth, this.$refs.scene.clientHeight );
      // renderer.outputEncoding = THREE.sRGBEncoding;
      // container.appendChild( renderer.domElement );
      //
      // const pmremGenerator = new THREE.PMREMGenerator( renderer );
      //
      // const scene = new THREE.Scene();
      // scene.background = new THREE.Color( 0xbfe3dd );
      // scene.environment = pmremGenerator.fromScene( new RoomEnvironment(), 0.04 ).texture;
      //
      // const camera = new THREE.PerspectiveCamera( 40, this.$refs.scene.clientWidth / this.$refs.scene.clientHeight, 1, 100 );
      // camera.position.set( 5, 2, 8 );
      //
      // const controls = new OrbitControls( camera, renderer.domElement );
      // controls.target.set( 0, 0.5, 0 );
      // controls.update();
      // controls.enablePan = false;
      // controls.enableDamping = true;
      //
      // const dracoLoader = new DRACOLoader();
      // dracoLoader.setDecoderPath( 'jsm/libs/draco/gltf/' );
      //
      // const loader = new GLTFLoader();
      // loader.setDRACOLoader( dracoLoader );
      // loader.load( 'models/gltf/LittlestTokyo.glb', function ( gltf ) {
      //
      //   const model = gltf.scene;
      //   model.position.set( 1, 1, 0 );
      //   model.scale.set( 0.01, 0.01, 0.01 );
      //   scene.add( model );
      //
      //   mixer = new THREE.AnimationMixer( model );
      //   mixer.clipAction( gltf.animations[ 0 ] ).play();
      //
      //   animate();
      //
      // }, undefined, function ( e ) {
      //   console.error( "@",  e );
      //
      // } );
      //
      //
      // this.$refs.scene.onresize = function () {
      //
      //   camera.aspect = this.$refs.scene.clientWidth / this.$refs.scene.clientHeight;
      //   camera.updateProjectionMatrix();
      //
      //   renderer.setSize( this.$refs.scene.clientWidth, this.$refs.scene.clientHeight );
      //
      // };
      //
      //
      // function animate() {
      //
      //   requestAnimationFrame( animate );
      //
      //   const delta = clock.getDelta();
      //
      //   mixer.update( delta );
      //
      //   controls.update();
      //
      //   stats.update();
      //
      //   renderer.render( scene, camera );
      //
      // }
    },
    animate () {
      this.renderer.render(this.scene, this.camera); //执行渲染操作
      requestAnimationFrame(this.animate)
    }
  },
  mounted () {
    this.init()
  }

}
</script>


<style>
.scene {
  width: 100%;
  height: 0;
  padding-bottom: 50%;
}
.w-20 {
  width: 20%;
}
.h-small {
  height: 10px;
}
@media (max-width: 992px) {
  .scene {
    width: 100%;
    height: 0;
    padding-bottom: 0;
  }
}
</style>
