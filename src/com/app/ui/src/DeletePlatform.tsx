// src/components/LoginPage.jsx

import { useState } from "react";
import { useNavigate } from 'react-router-dom';


function DeletePlatform() {
	const navigate = useNavigate();


	const [query, setQuery] = useState('');

	const [page, setPage] = useState<number>();
	const [size, setSize] = useState<number>();

	const [error, setError] = useState<string | null>(null);
	const [data, setData] = useState<string | null>(null);



	const handleSearch = (event: React.MouseEvent<HTMLButtonElement>) => {
		event.preventDefault();
		const token = localStorage.getItem('jwtToken');

		let searchUrl = "/api/search-notes?title=<title>&content=<content>&page={page}&size={size}";
		console.log("searchUrl :: ".concat(searchUrl))
		setPage(0);
		setSize(0);
		searchUrl = searchUrl.replace("<title>",query);
		searchUrl=  searchUrl.replace("<content>",query);
		searchUrl=  searchUrl.replace("{page}","0");
		searchUrl=  searchUrl.replace("{size}","100");

		console.log("@ searchUrl :: ".concat(searchUrl))


		fetch(searchUrl, {
			method: 'GET',
			headers: {
				'Content-Type': 'application/json',
				'Authorization': `Bearer ${token}`
			},
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
						
						const tableCard = document.getElementById('table-card');
						tableCard?.removeAttribute("hidden");
						const noteTable = document.getElementById('notes-table');
						const tableBody = noteTable.getElementsByTagName('tbody')[0];

						console.log(jsonResponse.data.length);
						const note = jsonResponse.data;
						for (let i = 0; i < jsonResponse.data.length ; i++) {
							const row = tableBody.insertRow();
							row.insertCell().textContent = String(i);
							row.insertCell().textContent = note[i].title;
							row.insertCell().textContent = note[i].content;
							row.insertCell().textContent = note[i].createdAt;
							row.insertCell().textContent = note[i].tags.toString();

						}
						
					
						
					//	navigate('/notes-search'); // Redirect to notes wigdets

					}
				} catch (err) {
					if (err instanceof Error) {
						setError(err.message);
					}

				}
			})
			.catch(error => console.error('Error :', error));
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
										<label htmlFor="title" style={{fontWeight:'bold'}}>Search</label>
										<input
											type="text"
											className="form-control"
											id="title"
											placeholder="Search by note title or content"
											value={query}
											onChange={(e) => setQuery(e.target.value)}

										/>
									</div>
									
									<div id="table-card" className="mb-3" hidden>

								 <span style={{fontWeight:'bold'}}>My notes</span>
								
								<table className="table" id="notes-table" >
									<thead>
										<tr>
										    <th>#</th>
											<th>Title</th>
											<th>Content</th>
											<th>Date created</th>
											<th>Tags</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
								</div>
			
									
							
				

								<div className="text-center mb-3">
					
								  
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

					export default DeletePlatform;