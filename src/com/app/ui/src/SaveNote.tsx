// src/components/LoginPage.jsx

import { useState } from "react";
import { useNavigate } from 'react-router-dom';


function SaveNote() {
	const navigate = useNavigate();

	const [title, setTitle] = useState('');
	const [content, setContent] = useState('');
	const [tags, setTags] = useState('');
	
	

	const [error, setError] = useState<string | null>(null);
	const [data, setData] = useState<string | null>(null);



	const handleSave = (event: React.MouseEvent<HTMLButtonElement>) => {
		event.preventDefault();

		const note = {
			title: "",
			content: "",
			tags:  [] as string[]
		};
		

		const token = localStorage.getItem('jwtToken');
		
		console.log(token?.toString);


			note.title = title;
			note.content = content;
			if (tags.includes(",")) { // list of tags

				const listOfTags: string[] = tags.split(",");

				for (const tag of listOfTags) {
					note.tags.push(tag);
				}
			}
			
			if (!tags.includes(",")) { // single item


					note.tags.push(tags);
			
			}



		fetch('/api/notes', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
				'Authorization': `Bearer ${token}`
			},
			body: JSON.stringify(note),
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
						const errorAlert = document.getElementById('error-alert');
						if (errorAlert) {
							errorAlert.removeAttribute('hidden');
						}
						throw new Error("save note failed.");
					
					} else {
						setError(null)
						console.log("save note success")
						const successAlert = document.getElementById('success-alert');
						if(successAlert){
						successAlert.removeAttribute('hidden');
						}
						setData(jsonResponse.message);

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




	const handleEdit = (event: React.MouseEvent<HTMLButtonElement>) => {
		event.preventDefault();

		const note = {
			title: "",
			content: "",
			tags: []
		};
		note.title = title;
		note.content = content;

		const token = localStorage.getItem('jwtToken');


		fetch('/api/notes', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
				'Authorization': `Bearer ${token}`
			},
			body: JSON.stringify(note),
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

		const note = {
			title: "",
			content: "",
			tags: []
		};
		note.title = title;
		note.content = content;

		const token = localStorage.getItem('jwtToken');


		fetch('/api/notes', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
				'Authorization': `Bearer ${token}`
			},
			body: JSON.stringify(note),
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

		const note = {
			title: "",
			content: "",
			tags: []
		};
		note.title = title;
		note.content = content;

		const token = localStorage.getItem('jwtToken');


		fetch('/api/notes', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
				'Authorization': `Bearer ${token}`
			},
			body: JSON.stringify(note),
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
	
	

	const handleSearch = (event: React.MouseEvent<HTMLButtonElement>) => {
		event.preventDefault();

		navigate('/notes-search'); // Redirect to notes wigdets

	};



	return (
		<div className="container" >
			<div className="row justify-content-center" style={{ marginLeft: '30rem' }}>
				<h2 style={{ textAlign: 'center' }}>Notes 5.0</h2>
				
			
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
										<label htmlFor="title" className="form-label">Title</label>
										<input
											type="text"
											className="form-control"
											id="title"
											value={title}
											onChange={(e) => setTitle(e.target.value)}

										/>
									</div>
									<div className="mb-3">
										<label htmlFor="content" className="form-label">Content</label>
										<textarea className="form-control" id="content" rows={4} value={content} onChange={(e) => setContent(e.target.value)}
										></textarea>
									</div>
									

								<div className="mb-3">
									<label htmlFor="tags" className="form-label">Tags</label>
									<input
										type="text"
										className="form-control"
										id="tags"
										value={tags}
										onChange={(e) => setTags(e.target.value)}

									/>
								</div>

								<div className="text-center mb-3">
								
								  <button data-mdb-ripple-init type="button" onClick={handleSave} className="btn btn-secondary btn-floating mx-1">
								  	Save
								  </button>


								  <button data-mdb-ripple-init type="button" onClick={handleEdit} className="btn btn-secondary btn-floating mx-1">
								  	Edit
								  </button>


								  <button data-mdb-ripple-init type="button" onClick={handleDelete} className="btn btn-secondary btn-floating mx-1">
								  	Delete
								  </button>


								  <button data-mdb-ripple-init type="button" onClick={handleView} className="btn btn-secondary btn-floating mx-1">
								  	View
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

					export default SaveNote;