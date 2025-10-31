// src/components/LoginPage.jsx

import { useState } from "react";
import { useNavigate } from 'react-router-dom';


function SavePlatform() {
	const navigate = useNavigate();

	const [name, setName] = useState('');
	const [url, setUrl] = useState('');
	const [resources, setResources] = useState('');
	
	

	const [error, setError] = useState<string | null>(null);
	const [data, setData] = useState<string | null>(null);



	const handleSave = (event: React.MouseEvent<HTMLButtonElement>) => {
		event.preventDefault();

		const platform = {
			name: "",
			url: "",
			resources:  [] as string[]
		};
		

		const token = localStorage.getItem('jwtToken');
		
		console.log(token?.toString);


			platform.name = name;
			platform.url = url;
			if (resources.includes(",")) { // list of tags

				const listOfResources: string[] = resources.split(",");

				for (const resource of listOfResources) {
					platform.resources.push(resource);
				}
			}
			
			if (!resources.includes(",")) { // single item


					platform.resources.push(resources);
			
			}



		fetch('/api/notes', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
				'Authorization': `Bearer ${token}`
			},
			body: JSON.stringify(platform),
		})
			.then(response => {
				if (!response.ok) {
					throw new Error(response.statusText);
				}
				return response.json();
			})
			.then((jsonResponse) => {

				try {
					console.log('save platform api call was successful:', jsonResponse)
					if (jsonResponse.status === "failed") {
						console.log("failed save platform ")
						const errorAlert = document.getElementById('error-alert');
						if (errorAlert) {
							errorAlert.removeAttribute('hidden');
						}
						throw new Error("save platform failed.");
					
					} else {
						setError(null)
						console.log("save note success")
						const successAlert = document.getElementById('success-alert');
						if(successAlert){
						successAlert.removeAttribute('hidden');
						}
						setData(jsonResponse.message);

						navigate('/platforms'); // Redirect to notes wigdets

					}
				} catch (err) {
					if (err instanceof Error) {
						setError(err.message);
					}

				}
			})
			.catch(error => console.error('Error :', error));
	};




	const handleEdit = (event: React.MouseEvent<HTMLButtonElement>) => {
		event.preventDefault();

		const platform = {
			name: "",
			url: "",
			resources: []
		};
		platform.name = name;
		platform.url = url;
	//	platform.resources = resources;


		const token = localStorage.getItem('jwtToken');


		fetch('/api/notes', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
				'Authorization': `Bearer ${token}`
			},
			body: JSON.stringify(platform),
		})
			.then(response => {
				if (!response.ok) {
					throw new Error(response.statusText);
				}
				return response.json();
			})
			.then((jsonResponse) => {

				try {
					console.log('save note api call was successful:', jsonResponse)
					if (jsonResponse.status === "failed") {
						console.log("failed save note ")
						throw new Error("save note failed.");
					} else {
						setError(null)
						console.log("save note success")
						navigate('/notes'); // Redirect to notes wigdets

					}
				} catch (err) {
					if (err instanceof Error) {
						setError(err.message);
					}

				}
			})
			.catch(error => console.error('Error :', error));
	};

	
	

	const handleDelete = (event: React.MouseEvent<HTMLButtonElement>) => {
		event.preventDefault();

		const platform = {
			name: "",
			url: "",
			resources: []
		};
		platform.name = name;
		platform.url = url;

		const token = localStorage.getItem('jwtToken');


		fetch('/api/notes', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
				'Authorization': `Bearer ${token}`
			},
			body: JSON.stringify(platform),
		})
			.then(response => {
				if (!response.ok) {
					throw new Error(response.statusText);
				}
				return response.json();
			})
			.then((jsonResponse) => {

				try {
					console.log('save note api call was successful:', jsonResponse)
					if (jsonResponse.status === "failed") {
						console.log("failed save note ")
						throw new Error("save note failed.");
					} else {
						setError(null)
						console.log("save note success")
						navigate('/notes'); // Redirect to notes wigdets

					}
				} catch (err) {
					if (err instanceof Error) {
						setError(err.message);
					}

				}
			})
			.catch(error => console.error('Error :', error));
	};



	const handleView = (event: React.MouseEvent<HTMLButtonElement>) => {
		event.preventDefault();

		const platform = {
			name: "",
			url: "",
			resources: []
		};
		platform.name = name;
		platform.url = url;

		const token = localStorage.getItem('jwtToken');


		fetch('/api/notes', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
				'Authorization': `Bearer ${token}`
			},
			body: JSON.stringify(platform),
		})
			.then(response => {
				if (!response.ok) {
					throw new Error(response.statusText);
				}
				return response.json();
			})
			.then((jsonResponse) => {

				try {
					console.log('save platform api call was successful:', jsonResponse)
					if (jsonResponse.status === "failed") {
						console.log("failed save note ")
						throw new Error("save note failed.");
					} else {
						setError(null)
						console.log("save plaftorm success")
						navigate('/platforms'); // Redirect to notes wigdets

					}
				} catch (err) {
					if (err instanceof Error) {
						setError(err.message);
					}

				}
			})
			.catch(error => console.error('Error :', error));
	};
	
	

	const handleSearch = (event: React.MouseEvent<HTMLButtonElement>) => {
		event.preventDefault();

		navigate('/notes-search'); // Redirect to notes wigdets

	};



	return (
		<div className="container" >
			<div className="row justify-content-center" style={{ marginLeft: '30rem' }}>
				<h2 style={{ textAlign: 'center' }}>Platform</h2>
				
			
				<div   id="success-alert" hidden={true} className="alert alert-success" role="alert">
							{data && <p style={{ textAlign: 'center', color: 'black' }}>{data}</p>}
							</div>
							
							
				
				<div   id="error-alert" hidden={true} className="alert alert-warning" role="alert">

				{error && <p style={{ textAlign: 'center', color: 'red' }}>{error}</p>}
				</div>

				<div className="col-md-12"   >

					<div className="card" >
						<div className="card-body">
							<form >
							<div className="mb-3">
										<label htmlFor="title" className="form-label">Name</label>
										<input
											type="text"
											className="form-control"
											id="name"
											value={name}
											onChange={(e) => setName(e.target.value)}

										/>
									</div>
									
									
									<div className="mb-3">
												<label htmlFor="title" className="form-label">URL</label>
												<input
													type="text"
													className="form-control"
													id="url"
													value={url}
													onChange={(e) => setUrl(e.target.value)}

												/>
											</div>
											
								<div className="mb-3">
									<label htmlFor="tags" className="form-label">Resources</label>
									<input
										type="text"
										className="form-control"
										id="tags"
										value={resources}
										onChange={(e) => setResources(e.target.value)}

									/>
								</div>

								<div className="text-center mb-3">
								
								  <button data-mdb-ripple-init type="button" onClick={handleSave} className="btn btn-secondary btn-floating mx-1">
								  	Create
								  </button>


								  <button data-mdb-ripple-init type="button" onClick={handleEdit} className="btn btn-secondary btn-floating mx-1">
								  	Edit
								  </button>


								  <button data-mdb-ripple-init type="button" onClick={handleDelete} className="btn btn-secondary btn-floating mx-1">
								  	Delete
								  </button>


								  <button data-mdb-ripple-init type="button" onClick={handleView} className="btn btn-secondary btn-floating mx-1">
								  	List
								  </button>
								  
								  
								  <button data-mdb-ripple-init type="button" onClick={handleSearch} className="btn btn-secondary btn-floating mx-1">
								  	Search
								  </button>


								  
								</div>		

											</form>
										</div>
									</div>
								</div>
						</div>
					</div>
					);
};

					export default SavePlatform;