import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import React, {useState} from 'react';

function Options({options}){
    if(options.length ===0 ) return (
        <></>
    )

    return (
        <React.Fragment>
            <select name="option">
                <option value="">옵션선택</option>

                {options.map(v =>
                    <option value="1">{v.name} +{v.price}원</option>
                )}

            </select>
        </React.Fragment>
    )
}

function Menu(props) {

    const name = props.name;
    const price = props.price;
    const imageUrl = props.imageUrl;
    const options = props.options;

    return (
        <React.Fragment>
            <img src={imageUrl} alt="빅맥"/>
            <div> {name}</div>
            <div> {price} 원</div>
            <Options options={options}/>
            <div className="col text-end action"><a className="btn btn-small btn-outline-dark" href="">추가</a></div>
        </React.Fragment>
    )
}

function MenuList({menus = []}) {
    return (
        <React.Fragment>
            <div>
                <table className="table">
                    <tbody>
                    {menus.map(v =>
                        <tr key={v.id}>
                            <td>
                                <Menu name={v.name} price={v.price} imageUrl={v.imageUrl} options = {v.options}/>
                            </td>
                        </tr>
                    )}
                    </tbody>
                </table>
            </div>
        </React.Fragment>
    )
}

function SummaryItem({name}) {
    return (
        <React.Fragment>
            <div className="row">
                <h6 className="p-0">{name}</h6>
            </div>
        </React.Fragment>
    )
}

function Summary({items = []}) {

    const totalPrice = items.reduce((prev, curr) => prev + curr.price, 0);

    return (
        <React.Fragment>

            <div className="summary p-4">
                <div>
                    <h5 className="m-0 p-0"><b>Summary</b></h5>
                </div>

                {items.map(v => <SummaryItem key={v.id} menuName={v.menuName}/>)

                }

                <div className="row pt-2 pb-2 border-top">
                    <h5 className="col">총금액</h5>
                    <h5 className="col text-end">{totalPrice}원</h5>
                </div>
                <button className="btn btn-dark col-12">주문하기</button>
            </div>
        </React.Fragment>
    )
}


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
        {id: '1', name: '불고기 버거', price:2300}
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
