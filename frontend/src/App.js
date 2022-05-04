import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import React, {useState} from 'react';
import {MenuList} from "./components/MenuList";
import {Summary} from "./components/Summary";


function App() {

    const [menus, setMenus] = useState([
        {id: '1', name: '불고기 버거', price: 2300, imageUrl : 'https://www.mcdonalds.co.kr/upload/product/pcfile/1583727805044.png', options:[{id:'1', name:"피클을 빼줘", price:0}]},
        {id: '2', name: '빅맥', price: 4600, imageUrl : 'https://www.mcdonalds.co.kr/upload/product/pcfile/1583727855319.png', options:[{id:'1', name:"피클을 빼줘", price:0}]},
        {id: '3', name: '불고기 버거 세트', price: 4300, imageUrl : 'https://www.mcdonalds.co.kr/upload/product/pcfile/1583730523630.png', options:[{id:'2', name:"제로 콜라로 바꿔줘", price:0}, {id:'3', name:"감튀를 맥너겟으로 바꿔줘", price:600}]},
        {id: '4', name: '빅맥 세트', price: 5900, imageUrl : 'https://www.mcdonalds.co.kr/upload/product/pcfile/1614163187334.png', options:[{id:'2', name:"제로 콜라로 바꿔줘", price:0}, {id:'3', name:"감튀를 맥너겟으로 바꿔줘", price:600}]},
        {id: '5', name: '후렌치 후라이 M', price: 1700, imageUrl : 'https://www.mcdonalds.co.kr/uploadFolder/product/prov_201902070318045120.png', options:[]},
        {id: '6', name: '맥너겟 4조각', price: 1800, imageUrl : 'https://www.mcdonalds.co.kr/upload/product/pcfile/1612402131024.png', options:[]},
        {id: '7', name: '코카 콜라', price: 1300, imageUrl : 'https://www.mcdonalds.co.kr/upload/product/pcfile/1583889967380.png', options:[]},
        {id: '8', name: '코카 콜라 제로', price: 1300, imageUrl : 'https://www.mcdonalds.co.kr/upload/product/pcfile/1583890021601.png', options:[]}
    ]);


    const [items, setItems] = useState([
    ])

    const handleAddClicked = (id, optionIdx) =>{
        const menu = menus.find(v => v.id === id);

        const menu1 = {id : menu.id, name : menu.name, price : menu.price, imageUrl : menu.imageUrl, option : menu.options[optionIdx-2]==null?{}:menu.options[optionIdx-2]};
        setItems([...items, {...menu1}]);

        console.log(items);
    }

    return (
        <div className="App">
            <div className="row m-4">
                <h1 className="text-center">GC Bugger</h1>
            </div>
            <div className="card">
                <div>
                    <MenuList menus={menus} onAddClick={handleAddClicked}/>
                    <Summary items={items}/>
                </div>
            </div>
        </div>
    );
}

export default App;
