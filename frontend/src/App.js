import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import React, {useState} from 'react';
import {MenuList} from "./components/MenuList";
import {Summary} from "./components/Summary";


function App() {

    const [menus, setMenus] = useState([
        {id: '1', name: '불고기 버거', price: 2300, imageUrl : 'https://www.mcdonalds.co.kr/upload/product/pcfile/1583727805044.png', options:[{name:"피클을 빼줘", price:0}]},
        {id: '2', name: '빅맥', price: 4600, imageUrl : 'https://www.mcdonalds.co.kr/upload/product/pcfile/1583727855319.png', options:[{name:"피클을 빼줘", price:0}]},
        {id: '3', name: '불고기 버거 세트', price: 4300, imageUrl : 'https://www.mcdonalds.co.kr/upload/product/pcfile/1583730523630.png', options:[{name:"제로 콜라로 바꿔줘", price:0}, {name:"감튀를 맥너겟으로 빠꿔줘", price:600}]},
        {id: '4', name: '빅맥 세트', price: 5900, imageUrl : 'https://www.mcdonalds.co.kr/upload/product/pcfile/1614163187334.png', options:[{name:"제로 콜라로 바꿔줘", price:0}, {name:"감튀를 맥너겟으로 빠꿔줘", price:600}]},
        {id: '5', name: '후렌치 후라이 M', price: 1700, imageUrl : 'https://www.mcdonalds.co.kr/uploadFolder/product/prov_201902070318045120.png', options:[]},
        {id: '6', name: '맥너겟 4조각', price: 1800, imageUrl : 'https://www.mcdonalds.co.kr/upload/product/pcfile/1612402131024.png', options:[]},
        {id: '7', name: '코카 콜라', price: 1300, imageUrl : 'https://www.mcdonalds.co.kr/upload/product/pcfile/1583889967380.png', options:[]},
        {id: '8', name: '코카 콜라 제로', price: 1300, imageUrl : 'https://www.mcdonalds.co.kr/upload/product/pcfile/1583890021601.png', options:[]}
    ]);


    const [items, setItems] = useState([
        {id: '1', menuName: '불고기 버거', price:2300}
    ])

    return (
        <div className="App">
            <div className="row m-4">
                <h1 className="text-center">GC Bugger</h1>
            </div>
            <div className="card">
                <div>
                    <MenuList menus={menus}/>
                    <Summary items={items}/>
                </div>
            </div>
        </div>
    );
}

export default App;
