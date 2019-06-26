import App from './pages/App'
import React  from 'react'
import ReactDOM from 'react-dom'
import registerServiceWorker from './config/registerServiceWorker'
import 'bootstrap/dist/css/bootstrap.min.css';

ReactDOM.render(
	<App /> ,
	document.getElementById('root')
);
registerServiceWorker();

