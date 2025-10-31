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
          target: 'http://localhost:8002',
          changeOrigin: true,
        },
		'/auth': {
		       target: 'http://localhost:8002', // Backend 2
		       changeOrigin: true,
		     },
      },
	  
    },
})


