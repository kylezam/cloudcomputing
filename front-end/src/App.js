import './App.css';
import React from 'react';
import {generateNumers,getAllResults,getLargest,getSmallest,clearDatabase,googleTest} from './Service.js';

function App() {
return (
    <div className="App">
      <header className="App-header">
        Number Generator Cloud Tool
      </header>
      <div>
      <body>
        <button onClick={googleTest}>Test</button>
        <button onClick={generateNumers}>Generate Numbers</button>
        <button onClick={getAllResults}>Get all Results</button>
        <button onClick={getLargest}>Get Largest Number</button>
        <button onClick={getSmallest}>Get Smallest Button</button>
        <button onClick={clearDatabase}>Clear Database</button>
      </body>
      </div>
    </div>
  );
}

export default App;
