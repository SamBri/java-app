import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'

import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS
import Signup from './Signup.tsx'
import SavePlatform from './SavePlatform.tsx'
//import SearchNote from './SearchNote.tsx'


const router = createBrowserRouter([
  {
    path: '/',
    element: <App />,
  },

  {
     path: '/platforms',
     element: <SavePlatform />,
   },
   {
        path: '/signup',
        element: <Signup />,
      }
//	  {
//	         path: '/notes-search',
//	         element: <SearchNote />,
//	       }
]);

createRoot(document.getElementById('root')!).render(
  <StrictMode>
<RouterProvider router={router} />
  </StrictMode>
)

