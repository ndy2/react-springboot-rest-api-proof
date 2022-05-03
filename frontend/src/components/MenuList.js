import React, {useState} from "react";
import {Menu} from "./Menu";

export function MenuList({menus = []}) {
    return (
        <React.Fragment>
            <div>
                <table className="table">
                    <tbody>
                    {menus.map(v =>
                        <tr key={v.id}>
                            <td>
                                <Menu name={v.name} price={v.price} imageUrl={v.imageUrl} options={v.options}/>
                            </td>
                        </tr>
                    )}
                    </tbody>
                </table>
            </div>
        </React.Fragment>
    )
}