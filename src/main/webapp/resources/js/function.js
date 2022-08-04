'use strict';
function closeModal() {
	document.getElementById('modal').classList.add('hidden')
}

async function openModal(event) {
	console.log(event.target.parentNode.getAttribute('idx'))
	
	
	const idx = event.target.parentNode.getAttribute('idx')
	const root = document.getElementById('root')
	
	const url = cpath + '/bestseller/' + idx
	await fetch(url)
	.then(resp => resp.json())
	.then(json => {
		
		const content = document.querySelector('.content')
		content.innerHTML = ''	
			
			
		const img = document.createElement('img')	 
		img.src = cpath + '/upload/' + json.img					
		img.title = json.title
		content.appendChild(img)
				
		content.setAttribute('idx', idx)
		
		const bookname = document.querySelector('.title')
		bookname.innerText = json.bookname
		content.appendChild(bookname)
		
		const writer = document.querySelector('.writer')
		writer.innerText = json.writer
		content.appendChild(writer)
		
		const price = document.createElement('div')
		price.className = 'price'
		price.innerText = json.price
		content.appendChild(price)
		
		const pdate = document.createElement('div')
		pdate.className = 'pdate'
		pdate.innerText = new Date(json.pdate).toISOString().split('T')[0]
		
		content.appendChild(pdate)
		
		const btn = document.createElement('button')
		btn.className = 'btn'
		btn.innerText = '삭제'
		btn.setAttribute('idx' , json.idx)
		btn.addEventListener('click', deleteHandler)
		content.appendChild(btn)
		
	})
	document.getElementById('modal').classList.remove('hidden')

}

function deleteHandler(event){ 
	console.log(event.target.getAttribute('idx'))
	
	const idx = event.target.getAttribute('idx')
	
	const flag = confirm('정말 삭제하시겠습니까')
	if(flag == false) {
		return
	}
	const item = event.target.parentNode.parentNode
	
	const url = cpath + '/bestseller/' + idx
	const opt = {
		method: 'DELETE'
	}
	fetch(url, opt)
	.then(resp => resp.text())
	.then(text => {
		if(text == 1) {
			alert('삭제 성공')
			location.reload(false)
		}
	})
}

function convert(dto){
	const item = document.createElement('div')
	item.className = 'item'
	
	const idx = document.createElement('div')
	idx.className = 'idx'
	idx.innerText = dto.idx
	
	const div = document.createElement('div')
	div.className = 'a'
	div.setAttribute('idx', dto.idx)
	
	
	const writer = document.createElement('div')
	writer.className = 'writer'
	writer.innerText = dto.writer
	
	const img = document.createElement('div')
	img.className = 'img'
	img.style.backgroundImage = `url('${cpath}/upload/${dto.img}')`
	img.addEventListener('click', openModal)
	
	const bookname = document.createElement('div')
	bookname.className = 'title'
	bookname.innerText = dto.bookname
	
	
	
	
//	const del = document.createElement('div')
//	del.className = 'del'
//	const btn = document.createElement('button')
//	btn.innerText = '삭제'
//	btn.addEventListener('click', deleteHandler)
//	
//	del.appendChild(btn)
	
	div.appendChild(idx)
	div.appendChild(img)
	div.appendChild(bookname)
	div.appendChild(writer)
//	div.appendChild(del)
	item.appendChild(div)
	
	return item
}

function selectAll(event){
const root = document.getElementById('root')
const url = cpath + '/bestseller'

fetch(url)
.then(resp => resp.json())
.then(json => {
//		console.log(json)
	json.forEach(dto => root.appendChild(convert(dto)))
	
	})
}

async function submitHandler(event){
	event.preventDefault()
	const root = document.getElementById('root')
	const formdata = new FormData(event.target)
	const url = cpath + '/bestseller'
	const opt = {
			method: 'POST',
			body: formdata
	}
	await fetch(url, opt)
	.then(resp => resp.text())
	.then(text => {
		if(text == 1){
			alert('성공')
		}
		event.target.reset()
	})
	root.innerHTML = ''
	selectAll()
}
