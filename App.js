import React, { useState } from 'react';
import './App.css';

function App() {
  const [items, setItems] = useState([]);
  const [inputValue, setInputValue] = useState('');

  const handleInputChange = (e) => {
    setInputValue(e.target.value);
  };

  const handleAddItem = () => {
    if (inputValue.trim() !== '') {
      setItems([...items, inputValue]);
      setInputValue('');
    }
  };

  return (
    <div className="App">
      <header className="App-header">
        <h1>Item List</h1>
        <div>
          <input
            type="text"
            value={inputValue}
            onChange={handleInputChange}
            placeholder="Enter item"
          />
          <button onClick={handleAddItem}>Add Item</button>
        </div>
        <ul>
          {items.map((item, index) => (
            <li key={index}>{item}</li>
          ))}
        </ul>
      </header>
    </div>
  );
}

export default App;