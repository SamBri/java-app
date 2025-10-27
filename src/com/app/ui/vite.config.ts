import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  build: {
    outDir: '../resources/static/',
    emptyOutDir: true,
  },
  css: {
          preprocessorOptions: {
            scss: {
              additionalData: `@import "bootstrap/scss/bootstrap.scss";`,
            },
          },
        },
  server: {
      proxy: {
         '/api': {
          target: 'http://localhost:8088',
          changeOrigin: true,
        },
		'/user': {
		       target: 'http://localhost:8088', // Backend 2
		       changeOrigin: true,
		     },
      },
	  
    },
})


