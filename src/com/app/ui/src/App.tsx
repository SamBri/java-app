import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';


function App() {
	const navigate = useNavigate();

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState<string | null>(null);


   const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
	event.preventDefault(); 
	 console.log('Username:', username);

	 const user = {
		username:"",
		password:""
	 };
	 user.username = username;
	 user.password = password;
	 
    fetch('/user/authentication', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(user),
    })
	.then(response =>{
		if (!response.ok) {
		          throw new Error(response.statusText);
		        }
		        return response.json();
	})
    .then((jsonResponse) => {
		
		try {
		console.log('user authentication api call was successful:', jsonResponse)
		if(jsonResponse.status === "failed"){
			console.log("failed user login ")
			const errorAlert = document.getElementById('error-alert');
			if(errorAlert){
			errorAlert.removeAttribute('hidden');
			}
			throw new Error("login failed.");
		}else{
			setError(null)
			console.log("login success")
			localStorage.setItem('jwtToken', jsonResponse.data);

			navigate('/notes'); // Redirect to notes wigdets

		}
		} catch (err) {
			 if(err instanceof Error){
			setError(err.message);
			 }
		     
		   }
	})
    .catch(error => console.error('Error authenticating user:', error));
  };

  
  const handleSignup = (event: React.MouseEvent<HTMLAnchorElement>) => {
  event.preventDefault(); 
  
  console.log("log home")

   navigate('/signup'); // signup route

  };





  return (
    <div className="container" >
      <div className="row justify-content-center" style={{marginLeft:'30rem'}}>
	  <h2 style={{ textAlign:'center' }}>Notes 5.0</h2> 
	  
	  <div   id="error-alert" hidden={true} className="alert alert-danger" role="alert">

	  			{error && <p style={{ textAlign: 'center', color: 'black' }}>{error}</p>}
	  			</div>
				
				
	   <div className="col-md-12"   >
	   
          <div className="card" >
            <div className="card-body">
              <form onSubmit={handleSubmit}>
                <div className="mb-3">
                  <label htmlFor="username" className="form-label">Username</label>
                  <input
                    type="text"
                    className="form-control"
                    id="username"
                    value={username}
					onChange={(e) => setUsername(e.target.value)}
                    required
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="password" className="form-label">Password</label>
                  <input
                    type="password"
                    className="form-control"
                    id="password"
                    value={password}
					onChange={(e) => setPassword(e.target.value)}
                    required
                  />
                </div>
                <button type="submit" className="btn btn-primary" style={{ marginLeft:'35%', width:"35%" }}>Login</button>
				<div className="text-center" style={{paddingTop:'5%'}} >
					    <p><a href="!#" onClick={handleSignup}>Signup to Notes</a></p>
				</div>
				 </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default App;
